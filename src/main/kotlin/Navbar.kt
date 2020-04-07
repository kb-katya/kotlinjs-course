import data.tabList
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*


interface RNavbarProps: RProps {
    var onClickTab: (Int) -> Unit
}

fun RBuilder.fnavbar(onClickTab: (index: Int) -> Unit) =
    child(
        functionalComponent<RNavbarProps> {
            nav {
                attrs.id = "navbar"
                img {
                    attrs.src = "./images/logo.png"
                }
                tabList.mapIndexed { index, tab ->
                    div {
                        h1 {
                            +tab.title
                            attrs.onClickFunction = { _ ->
                                it.onClickTab(index)
                            }
                        }
                    }
                }
            }
        }
    ) {
        attrs.onClickTab = onClickTab
    }