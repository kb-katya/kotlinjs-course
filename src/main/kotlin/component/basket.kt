package component

import data.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface BasketProps: RProps {
    var account: Pair<Int, Account>?
    var orderBasket: Map<String, Int>
    var dishesBasket: Map<Int, Pair<Dish, Int>>
    var couponsBasket: Map<Int, Pair<Coupon, Int>>
    var resetBasket: (Event) -> Unit
    var submitBasket: (Order) -> (Event) -> Unit
}

val fBasket =
    functionalComponent<BasketProps> { props ->
        fun RBuilder.tableRow (title: String, count: String, sum: String) {
            tr {
                td {
                    +title
                }
                td {
                    +count
                }
                td {
                    +sum
                }
            }
        }
        val sum = (props.dishesBasket.map { it.value.first.price * it.value.second }.sum()
                + props.couponsBasket.map { it.value.first.price * it.value.second }.sum())
        div("basket") {
            h1 {
                +"Корзина"
            }
            table {
                caption {
                    +"ИТОГО СУММА: ${sum} ₽"
                }
                tr {
                    th {
                        +"Наименование"
                    }
                    th {
                        +"Количество"
                    }
                    th {
                        +"Итого"
                    }
                }
                props.dishesBasket.map {
                    tableRow(it.value.first.title, it.value.second.toString(),
                        "${it.value.second} * ${it.value.first.price} = ${it.value.second * it.value.first.price}"
                    )
                }
                props.couponsBasket.map {
                    tableRow("Купон №${it.value.first.code}", it.value.second.toString(),
                        "${it.value.second} * ${it.value.first.price} = ${it.value.second * it.value.first.price}"
                    )
                }
            }
            button {
                attrs.onClickFunction = props.resetBasket
                +"Очистить корзину"
            }
            button {
                if (props.account != null && props.orderBasket.isNotEmpty()) {
                    val order = Order(props.account!!.first, props.orderBasket, sum)
                    attrs.onClickFunction = props.submitBasket(order)
                }
                attrs.disabled = props.account == null || props.orderBasket.isEmpty()
                +"Оформить заказ"
            }
        }
    }

fun RBuilder.basket(
    account: Pair<Int, Account>?,
    orderBasket: Map<String, Int>,
    dishesBasket: Map<Int, Pair<Dish, Int>>,
    couponsBasket: Map<Int, Pair<Coupon, Int>>,
    resetBasket: (Event) -> Unit,
    submitBasket: (Order) -> (Event) -> Unit
) = child(fBasket) {
    attrs.account = account
    attrs.orderBasket = orderBasket
    attrs.dishesBasket = dishesBasket
    attrs.couponsBasket = couponsBasket
    attrs.resetBasket = resetBasket
    attrs.submitBasket = submitBasket
}