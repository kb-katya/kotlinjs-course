package component

import container.dishListContainer
import data.*
import enums.TypeDish
import kotlinx.html.classes
import react.*
import react.dom.*
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event

interface MenuProps: RProps {
    var activeTypeDish: TypeDish
    var changeTypeDish: (TypeDish) -> (Event) -> Unit
}

val fMenu =
    functionalComponent<MenuProps> { props ->
        div {
            attrs.id = "header"
            ul {
                tabList.map {
                    li {
                        if (it.type == props.activeTypeDish)
                            attrs.classes = setOf("active")
                        +it.title
                        attrs.onClickFunction = props.changeTypeDish(it.type)
                    }
                }
            }
        }
        dishListContainer { }
    }

fun RBuilder.menu(
    activeTypeDish: TypeDish
) = child(fMenu) {
    attrs.activeTypeDish = activeTypeDish
}