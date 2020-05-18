package container

import react.*
import component.*
import react.redux.rConnect
import data.*
import hoc.withDisplayName
import redux.RAction
import redux.WrapperAction

interface BasketDispatchProps : RProps

interface BasketStateProps : RProps {
    var orderBasket: OrderBasketState
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
            orderBasket = state.orderBasket
        },
        { dispatch, _ -> }
    )(
        withDisplayName(
            "Basket",
            fBasket
        )
            .unsafeCast<RClass<BasketProps>>()
    )