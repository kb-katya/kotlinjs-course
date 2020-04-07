import data.Dish
import data.dishList
import kotlinx.html.classes
import react.*
import react.dom.*
import kotlinx.html.id
import kotlinx.html.js.onClickFunction


val menu = setOf("Бургеры", "Твистеры", "Курица", "Баскеты", "Снэки", "Соусы", "Напитки", "Десерты")

interface RMenuProps: RProps {
    var onClickAddDish: (Int) -> Unit
}

fun RBuilder.fmenu(onClickAddDish: (Int) -> Unit) =
    child(
        functionalComponent<RMenuProps> {
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
                dishList.mapIndexed { index, dish ->
                    div {
                        +dish.title
                        img {
                            attrs.src = dish.scr
                        }
                        attrs.onClickFunction = { _ ->
                            it.onClickAddDish(index)
                        }
                    }
                }
            }
        }
    ) {
        attrs.onClickAddDish = onClickAddDish
    }
