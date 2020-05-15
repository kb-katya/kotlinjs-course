package container

import component.*
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface AnyListDispatchProps : RProps {

}

interface AnyListStateProps<O> : RProps {
    var objs: Map<Int, O>
}

val dishListContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            AnyListStateProps<Dish>,
            AnyListDispatchProps,
            AnyListProps<Dish>
            >(
        mapStateToProps = { state, _ ->
            objs = state.dishList.filter {
                it.value.type == state.activeTypeDish
            }
        },
        mapDispatchToProps = { dispatch, _ ->

        }
    )(
        withDisplayName(
            "DishList",
            fAnyList("/menu", "object-list", RBuilder::dish)
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
            objs = state.couponList
        },
        { dispatch, _ ->

        }
    )(
        withDisplayName(
            "CouponList",
            fAnyList("/coupon","object-list", RBuilder::coupon)
        )
            .unsafeCast<RClass<AnyListProps<Coupon>>>()
    )