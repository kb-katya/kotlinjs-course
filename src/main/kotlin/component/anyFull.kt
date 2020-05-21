package component

import org.w3c.dom.events.Event
import react.*

interface AnyFullProps<O> : RProps {
    var obj: O
    var addToBasket: (Int) -> (Event) -> Unit
}

fun <O> fAnyFull(
    rComponent: RBuilder.(O, (Int) -> (Event) -> Unit) -> ReactElement
) =
    functionalComponent<AnyFullProps<O>> { props ->
        rComponent(props.obj, props.addToBasket)
    }