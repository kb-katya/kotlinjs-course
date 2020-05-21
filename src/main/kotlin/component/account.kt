package component

import data.Account
import data.Order
import react.*
import react.dom.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event

interface AccountProps : RProps {
    var account: Pair<Int, Account>
    var orderList: Map<Int, Order>
    var logout: (Event) -> Unit
}

val fAccount =
    functionalComponent<AccountProps> { props ->
        val accountId = props.account.first
        val account = props.account.second
        div("account") {
            h1 {
                +"Личный кабинет"
            }
            div("account-info") {
                label {
                    strong {
                        +"Код аккаунта: "
                    }
                    +accountId.toString()
                }
                label {
                    strong {
                        +"Имя: "
                    }
                    +account.name
                }
                label {
                    strong {
                        +"Номер телефона: "
                    }
                    +account.phoneNumber
                }
                label {
                    strong {
                        +"Количество баллов: "
                    }
                    +account.numberOfPoints.toString()
                }
                button {
                    attrs.onClickFunction = props.logout
                    +"Выйти из аккаунта"
                }
            }
            h2 {
                +"Список заказов:"
            }
            table {
                tr {
                    th {
                        +"Код заказа"
                    }
                    th {
                        +"Дата заказа"
                    }
                    th {
                        +"Итого"
                    }
                }
                props.orderList.map {
                    tr {
                        td {
                            +"Номер заказа №${it.key}"
                        }
                        td {
                            +"${it.value.data.toLocaleDateString()} ${it.value.data.toLocaleTimeString()}"
                        }
                        td {
                            +"${it.value.orderPrice} ₽"
                        }
                    }
                }
            }
        }
    }

fun RBuilder.account(
    account: Pair<Int, Account>,
    orderList: Map<Int, Order>,
    logout: (Event) -> Unit
) = child(fAccount) {
    attrs.account = account
    attrs.orderList = orderList
    attrs.logout = logout
}