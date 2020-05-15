package component

import data.*
import kotlinx.html.classes
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface CouponFullProps : RProps {
    var coupon: Coupon
    var addToBasket: (Int) -> (Event) -> Unit
}

val fCouponFull =
    functionalComponent<CouponFullProps> { props ->
        div {
            attrs.classes = setOf("object-full")
            +props.coupon.code.toString()
        }
    }

fun RBuilder.couponFull(
    coupon: Coupon,
    addToBasket: (Int) -> (Event) -> Unit
) = child(fCouponFull) {
    attrs.coupon = coupon
    attrs.addToBasket = addToBasket
}