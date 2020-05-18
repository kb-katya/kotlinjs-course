package component

import data.*
import kotlinx.html.*
import react.*
import react.dom.*

interface DishProps : RProps {
    var dish: Dish
}

val fDish =
    functionalComponent<DishProps> { props ->
        div {
            attrs.classes = setOf("object-list-item")
            img {
                attrs.src = props.dish.src
            }
            p {
                +props.dish.title
            }
        }
    }

fun RBuilder.dish(
    dish: Dish
) = child(fDish) {
    attrs.dish = dish
}