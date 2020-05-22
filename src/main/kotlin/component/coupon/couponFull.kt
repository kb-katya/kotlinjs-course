package component.coupon

import component.basketButton
import data.*
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.router.dom.navLink

interface CouponFullProps : RProps {
    var coupon: Coupon
    var addToBasket: (Int) -> (Event) -> Unit
}

interface CouponFullState : RState {
    var count: Int
}

class CouponFull : RComponent<CouponFullProps, CouponFullState>() {

    init {
        state.apply {
            count = 1
        }
    }

    val incrementCount: (Event) -> Unit = {
        setState { count++ }
    }

    val decrementCount: (Event) -> Unit = {
        if (state.count > 1)
            setState { count-- }
    }

    fun RBuilder.blockImg() {
        div("object-block-img") {
            img {
                attrs.src = props.coupon.src
            }
            div("coupon-block-description") {
                +props.coupon.description
            }
        }
    }

    fun RBuilder.couponOrder() {
        div("object-block-order") {
            h1 {
                +"Купон №${props.coupon.code}"
            }
            h2 {
                +"В купон входит:"
            }
            div("coupon-block-dishes") {
                props.coupon.foodList.map {
                    navLink("/menu/${it.key}") {
                        +"Блюдо №${it.key}: ${it.value} шт."
                    }
                }
            }
            basketButton(state.count, props.coupon.price, props.addToBasket(state.count), incrementCount, decrementCount)
        }
    }

    fun RBuilder.banner() {
        div("coupon-block-banner") {
            div("coupon-block-banner-code") {
                +"№XXXX"
            }
            span {
                +"Используйте купоны KFC для заказов в мобильном приложении и в ресторанах."
            }
        }
    }

    override fun RBuilder.render() {
        banner()
        div("object-full") {
            blockImg()
            couponOrder()
        }
    }
}

fun RBuilder.couponFull(
    coupon: Coupon,
    addToBasket: (Int) -> (Event) -> Unit
) = child(CouponFull::class) {
    attrs.coupon = coupon
    attrs.addToBasket = addToBasket
}