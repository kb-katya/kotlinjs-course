package component

import react.*
import react.dom.*
import kotlinx.html.id

val fNews =
    functionalComponent<RProps> {
        div {

        }
    }

fun RBuilder.news() = child(fNews) { }