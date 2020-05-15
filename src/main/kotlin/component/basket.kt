package component

import data.*
import react.*
import react.dom.*

val fBasket =
    functionalComponent<RProps> {

    }

fun RBuilder.basket() = child(fBasket) { }