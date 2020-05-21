package container

import react.*
import component.*
import react.redux.rConnect
import data.*
import org.w3c.dom.events.Event
import redux.CreateAccount
import redux.RAction
import redux.SetActiveAccount
import redux.WrapperAction

interface AuthDispatchProps : RProps {
    var login: (Pair<Int, Account>) -> (Event) -> Unit
    var registration: (Account) -> (Event) -> Unit
}

interface AuthStateProps : RProps {
    var accountList: AccountListState
}

val authContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            AuthStateProps,
            AuthDispatchProps,
            AuthProps
            >(
        { state, _ ->
            accountList = state.accountList
        },
        { dispatch, _ ->
            login = { account ->
                {
                    dispatch(SetActiveAccount(account))
                }
            }
            registration = { account ->
                {
                    dispatch(CreateAccount(account))
                }
            }
        }
    )(
        Auth::class.js.unsafeCast<RClass<AuthProps>>()
    )