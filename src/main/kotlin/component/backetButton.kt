package component

import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface BasketButtonProps : RProps {
    var count: Int
    var price: Int
    var onClickBasket: (Event) -> Unit
    var onClickIncrement: (Event) -> Unit
    var onClickDecrement: (Event) -> Unit
}

val fBasketButton =
    functionalComponent<BasketButtonProps> { props ->
        div("block-basket-button") {
            div {
                button {
                    attrs.classes = setOf("block-button-count")
                    attrs.onClickFunction = props.onClickDecrement
                    +"-"
                }
                span {
                    +props.count.toString()
                }
                button {
                    attrs.classes = setOf("block-button-count")
                    attrs.onClickFunction = props.onClickIncrement
                    +"+"
                }
            }
            button {
                +"В корзину - ${props.price * props.count} ₽"
                attrs.onClickFunction = props.onClickBasket
            }
        }
    }

fun RBuilder.basketButton(
    count: Int,
    price: Int,
    onClick: (Event) -> Unit,
    onClickIncrement: (Event) -> Unit,
    onClickDecrement: (Event) -> Unit
) = child(fBasketButton) {
    attrs.count = count
    attrs.price = price
    attrs.onClickBasket = onClick
    attrs.onClickIncrement = onClickIncrement
    attrs.onClickDecrement = onClickDecrement
}