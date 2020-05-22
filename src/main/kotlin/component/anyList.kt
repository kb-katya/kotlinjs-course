package component

import react.*
import react.dom.*
import react.router.dom.navLink

interface AnyListProps<O> : RProps {
    var isAdmin: Boolean
    var objs: Map<Int, O>
}

fun <O> fAnyList(
    path: String,
    title: String,
    cssClass: String,
    rObj: RBuilder.(O) -> ReactElement
) =
    functionalComponent<AnyListProps<O>> { props ->
        h1("object-list-h"){
            +title
        }
        if(props.isAdmin)
            h2("object-list-h") {
                navLink(path + "_add") {
                    +"Добавить"
                }
            }
        div(cssClass) {
            props.objs.map { obj ->
                navLink("$path/${obj.key}") {
                    rObj(obj.value)
                }
            }
        }
    }

