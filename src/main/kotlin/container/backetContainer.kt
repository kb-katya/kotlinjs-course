package container

import react.*
import component.*
import react.redux.rConnect
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import redux.RAction
import redux.ResetBasket
import redux.SubmitBasket
import redux.WrapperAction

interface BasketDispatchProps : RProps {
    var resetBasket: (Event) -> Unit
    var submitBasket: (Order) -> (Event) -> Unit
}

interface BasketStateProps : RProps {
    var account: Pair<Int, Account>?
    var orderBasket: Map<String, Int>
    var dishesBasket: Map<Int, Pair<Dish, Int>>
    var couponsBasket: Map<Int, Pair<Coupon, Int>>
}

val basketContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            BasketStateProps,
            BasketDispatchProps,
            BasketProps
            >(
        { state, _ ->
            account = state.activeAccount
            orderBasket = state.orderBasket
            dishesBasket = state.orderBasket.filter { it.key[0] == 'D' }.map {
                it.key.drop(1).toInt() to (state.dishList[it.key.drop(1).toInt()]!! to it.value)
            }.toMap()
            couponsBasket = state.orderBasket.filter { it.key[0] == 'C' }.map {
                it.key.drop(1).toInt() to (state.couponList[it.key.drop(1).toInt()]!! to it.value)
            }.toMap()
        },
        { dispatch, _ ->
            resetBasket = {
                dispatch(ResetBasket())
            }
            submitBasket = { order: Order ->
                {
                    dispatch(SubmitBasket(order))
                }
            }
        }
    )(
        withDisplayName(
            "Basket",
            fBasket
        )
            .unsafeCast<RClass<BasketProps>>()
    )