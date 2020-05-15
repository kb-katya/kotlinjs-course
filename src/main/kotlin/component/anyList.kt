package component

import kotlinx.html.classes
import react.*
import react.dom.*
import react.router.dom.navLink

interface AnyListProps<O> : RProps {
    var objs: Map<Int, O>
}

fun <O> fAnyList(
    path: String,
    cssClass: String,
    rObj: RBuilder.(O) -> ReactElement
) =
    functionalComponent<AnyListProps<O>> { props ->
        div(cssClass) {
            props.objs.map { obj ->
                navLink("$path/${obj.key}") {
                    rObj(obj.value)
                }
            }
        }
    }

