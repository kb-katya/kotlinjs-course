package container

import react.*
import component.*
import react.redux.rConnect
import data.*

val appContainer =
    rConnect<State, RProps, AppProps>(
        { state, _ ->
            dishList = state.dishList
            couponList = state.couponList
            accountList = state.accountList
            orderBasket = state.orderBasket
            activeAccount = state.activeAccount
        },
        {
            pure = false  // side effect of React Route
        }
    )(
        fApp().unsafeCast<RClass<AppProps>>()
    )