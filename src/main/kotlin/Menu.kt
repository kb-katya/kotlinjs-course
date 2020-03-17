import data.dishList
import kotlinx.html.classes
import react.*
import react.dom.*
import kotlinx.html.id

val menu = setOf("Бургеры", "Твистеры", "Курица", "Баскеты", "Снэки", "Соусы", "Напитки", "Десерты")

fun RBuilder.rmenu() =
    child(
        functionalComponent<RProps> {
            div {
                attrs.id = "header"
                div{
                    attrs.classes = setOf("menu")
                    ul{
                      menu.map {
                          li {
                              +it
                          }
                      }
                    }
                }
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
