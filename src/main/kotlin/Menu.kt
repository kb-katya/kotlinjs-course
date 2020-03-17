import data.dishList
import react.*
import react.dom.*
import kotlinx.html.id


fun RBuilder.rmenu() =
    child(
        functionalComponent<RProps> {
            h1 {
                +"Меню"
            }
            div {
                attrs.id = "menu"
                dishList.map {
                    div {
                        +it.title
                        img {
                            attrs.src = it.scr
                        }
                    }
                }
            }
        }
    ) { }