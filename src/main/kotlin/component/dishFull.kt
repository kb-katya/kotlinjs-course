package component

import data.*
import kotlinx.html.classes
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface DishFullProps : RProps {
    var dish: Dish
    var addToBasket: (Int) -> (Event) -> Unit
}

interface DishFullState : RState {
    var count: Int
}

class DishFull : RComponent<DishFullProps, DishFullState>() {

    init {
        state.apply {
            count = 1
        }
    }

    fun RBuilder.blockImg() {
        div("dish-block-img") {
            img {
                attrs.src = props.dish.scr
            }
            div("dish-block-addition") {
                +"* В некоторых ресторанах KFC продукты и цены могут отличаться.."
            }

        }
    }

    fun RBuilder.blockOrder() {
        div("dish-block-order") {
            h1 {
                +props.dish.title
            }
            div("dish-block-basket") {
                div {
                    button {
                        attrs.classes = setOf("dish-button-count")
                        attrs.onClickFunction = { if (state.count > 1) setState { count-- } }
                        +"-"
                    }
                    span {
                        +state.count.toString()
                    }
                    button {
                        attrs.classes = setOf("dish-button-count")
                        attrs.onClickFunction = { setState { count++ } }
                        +"+"
                    }
                }
                button {
                    +"В корзину - ${props.dish.price * state.count} ₽"
                    attrs.onClickFunction = props.addToBasket(state.count)
                }
            }
            div("dish-block-discription") {
                +props.dish.discription
            }
        }
    }

    override fun RBuilder.render() {
        div("object-full") {
            blockImg()
            blockOrder()
        }
    }
}

fun RBuilder.dishFull(
    dish: Dish,
    addToBasket: (Int) -> (Event) -> Unit
) = child(DishFull::class) {
    attrs.dish = dish
    attrs.addToBasket = addToBasket
}