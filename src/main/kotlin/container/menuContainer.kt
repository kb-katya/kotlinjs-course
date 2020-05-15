package container

import react.*
import component.*
import react.redux.rConnect
import data.*
import enums.TypeDish
import org.w3c.dom.events.Event
import redux.ChangeActiveTypeDish
import redux.RAction
import redux.WrapperAction

interface MenuDispatchProps : RProps {
    var changeTypeDish: (TypeDish) -> (Event) -> Unit
}

interface MenuStateProps : RProps {
    var activeTypeDish: ActiveTypeDishState
}

val menuContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            MenuStateProps,
            MenuDispatchProps,
            MenuProps
            >(
        { state, _ ->
            activeTypeDish = state.activeTypeDish
        },
        { dispatch, _ ->
            changeTypeDish = { typeDish ->
                {
                    dispatch(ChangeActiveTypeDish(typeDish))
                }
            }
        }
    )(
        fMenu.unsafeCast<RClass<MenuProps>>()
    )