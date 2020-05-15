package component

import data.*
import kotlinx.html.classes
import react.*
import react.dom.*

interface CouponProps : RProps {
    var coupon: Coupon
}

val fCoupon =
    functionalComponent<CouponProps> { props ->
        div {
            attrs.classes = setOf("object-list-item")
            +props.coupon.code.toString()
        }
    }

fun RBuilder.coupon(
    coupon: Coupon
) = child(fCoupon) {
    attrs.coupon = coupon
}