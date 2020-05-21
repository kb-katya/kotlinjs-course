package container

import react.*
import component.*
import react.redux.rConnect
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import redux.RAction
import redux.WrapperAction
import redux.SetActiveAccount

interface AccountDispatchProps : RProps {
    var logout: (Event) -> Unit
}

interface AccountStateProps : RProps {
    var account: Pair<Int, Account>
    var orderList: Map<Int, Order>
}

val accountContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            AccountStateProps,
            AccountDispatchProps,
            AccountProps
            >(
        { state, _ ->
            account = state.activeAccount!!
            orderList = state.orderList.filter {
                it.value.accountId == state.activeAccount.first
            }
        },
        { dispatch, _ ->
            logout = {
                dispatch(SetActiveAccount(null))
            }
        }
    )(
        withDisplayName(
            "Account",
            fAccount
        )
            .unsafeCast<RClass<AccountProps>>()
    )