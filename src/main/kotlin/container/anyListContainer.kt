package container

import component.*
import component.coupon.coupon
import component.dish.dish
import data.*
import hoc.withDisplayName
import react.*
import react.redux.rConnect
import redux.*

interface AnyListDispatchProps : RProps {

}

interface AnyListStateProps<O> : RProps {
    var isAdmin: Boolean
    var objs: Map<Int, O>
}

val dishListContainer =
    rConnect<
            State, // тип хранилища, которое мы присоединяем к компоненту
            RAction,
            WrapperAction,
            RProps, // собственные свойста dishListContainer'a
            AnyListStateProps<Dish>,
            AnyListDispatchProps,
            AnyListProps<Dish> // свойства компонента, который оборачивается
            >(
        mapStateToProps = { state, _ ->
            isAdmin =
                if (state.activeAccount == null)
                    false
                else
                    state.activeAccount.second.isAdmin
            objs = state.dishList.filter {
                it.value.type == state.activeTypeDish
            }
        },
        mapDispatchToProps = { dispatch, _ ->

        }
    )(
        withDisplayName(
            "Dish List",
            fAnyList("/menu", "Меню","object-list", RBuilder::dish)
        )
            .unsafeCast<RClass<AnyListProps<Dish>>>()
    )

val couponListContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            AnyListStateProps<Coupon>,
            AnyListDispatchProps,
            AnyListProps<Coupon>
            >(
        { state, _ ->
            isAdmin =
                if (state.activeAccount == null)
                    false
                else
                    state.activeAccount.second.isAdmin
            objs = state.couponList
        },
        { dispatch, _ -> }
    )(
        withDisplayName(
            "Coupon List",
            fAnyList("/coupon","Купоны","object-list", RBuilder::coupon)
        )
            .unsafeCast<RClass<AnyListProps<Coupon>>>()
    )