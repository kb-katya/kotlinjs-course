import component.coupon.CouponAdd
import component.coupon.CouponAddProps
import data.Coupon
import data.DishListState
import data.State
import org.w3c.dom.events.Event
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import redux.CreateCoupon
import redux.RAction
import redux.WrapperAction
import kotlin.browser.window

interface CouponAddDispatchProps : RProps {
    var createCoupon: (Coupon) -> (Event) -> Unit
}

interface CouponAddStateProps : RProps {
    var dishList: DishListState
}

val couponAddContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            CouponAddStateProps,
            CouponAddDispatchProps,
            CouponAddProps
            >(
        mapStateToProps = { state, _ ->
            dishList = state.dishList
        },
        mapDispatchToProps = { dispatch, _ ->
            createCoupon = { coupon ->
                {
                    dispatch(CreateCoupon(coupon))
                    window.history.back()
                }
            }
        }
    )(
        CouponAdd::class.js.unsafeCast<RClass<CouponAddProps>>()
    )