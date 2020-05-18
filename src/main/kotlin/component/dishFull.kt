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

    val incrementCount: (Event) -> Unit = {
        setState { count++ }
    }

    val decrementCount: (Event) -> Unit = {
        if (state.count > 1)
            setState { count-- }
    }

    fun RBuilder.blockImg() {
        div("object-block-img") {
            img {
                attrs.src = props.dish.src
            }
            div("dish-block-addition") {
                +"* В некоторых ресторанах KFC продукты и цены могут отличаться.."
            }
        }
    }

    fun RBuilder.blockOrder() {
        div("object-block-order") {
            h1 {
                +props.dish.title
            }
            basketButton(state.count, props.dish.price, props.addToBasket(state.count), incrementCount, decrementCount)
            div("dish-block-description") {
                +props.dish.description
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