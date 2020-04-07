import data.Dish
import data.dishList
import react.*
import react.dom.*
import kotlinx.html.id
import kotlinx.html.js.onClickFunction

interface RBasketProps: RProps {
    var basket: ArrayList<Dish>
    var onClickRemoveDish: (Int) -> Unit
}

fun RBuilder.fbasket(basket: ArrayList<Dish>, onClickRemoveDish: (Int) -> Unit) =
    child(
        functionalComponent<RBasketProps> {
            div {
                attrs.id = "basket"
                it.basket.mapIndexed { index, dish ->
                    div {
                        +dish.title
                        img {
                            attrs.src = dish.scr
                        }
                        attrs.onClickFunction = { _ ->
                            it.onClickRemoveDish(index)
                        }
                    }
                }
            }
        }
    ) {
        attrs.basket = basket
        attrs.onClickRemoveDish = onClickRemoveDish
    }
