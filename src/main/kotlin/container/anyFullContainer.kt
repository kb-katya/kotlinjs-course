package container

import component.*
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface AnyFullDispatchProps : RProps {
    var addToBasket: (Int) -> (Event) -> Unit
}

interface AnyFullStateProps<O> : RProps {
    var obj: O
}

interface AnyFullOwnProps<O> : RProps {
    var obj: Pair<Int, O>
}

val dishFullContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            AnyFullOwnProps<Dish>,
            AnyFullStateProps<Dish>,
            AnyFullDispatchProps,
            AnyFullProps<Dish>
            >(
        mapStateToProps = { state, ownProps ->
            obj = ownProps.obj.second
        },
        mapDispatchToProps = { dispatch, ownProps  ->
            addToBasket = { count ->
                {
                    dispatch(AddDishToBasket(ownProps.obj.first, count))
                }
            }
        }
    )(
        withDisplayName(
            "Dish Full",
            fAnyFull(RBuilder::dishFull)
        )
            .unsafeCast<RClass<AnyFullProps<Dish>>>()
    )

val couponFullContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            AnyFullOwnProps<Coupon>,
            AnyFullStateProps<Coupon>,
            AnyFullDispatchProps,
            AnyFullProps<Coupon>
            >(
        { state, ownProps ->
            obj = ownProps.obj.second
        },
        { dispatch, _ ->
            addToBasket = { { } }
        }
    )(
        withDisplayName(
            "Coupon",
            fAnyFull(RBuilder::couponFull)
        )
            .unsafeCast<RClass<AnyFullProps<Coupon>>>()
    )