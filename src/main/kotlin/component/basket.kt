package component

import data.*
import enums.TypeDish
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface BasketProps: RProps {
    var orderBasket: Map<Int, Int>
}

val fBasket =
    functionalComponent<BasketProps> { props ->
        props.orderBasket.map {
            console.log(it.key, it.value)
        }
        +"Basket"
    }

fun RBuilder.basket(
    orderBasket: Map<Int, Int>
) = child(fBasket) {
    attrs.orderBasket = orderBasket
}