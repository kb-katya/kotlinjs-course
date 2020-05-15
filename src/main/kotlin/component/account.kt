package component

import react.*
import react.dom.*
import kotlinx.html.id

val fAccount =
    functionalComponent<RProps> {
        div {
            h1 {
                +"Личный кабинет"
            }
        }
    }

fun RBuilder.account() = child(fAccount) { }