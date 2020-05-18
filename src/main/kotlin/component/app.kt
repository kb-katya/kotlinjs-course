package component

import data.*
import container.*
import react.*
import react.dom.p
import react.dom.section
import react.router.dom.RouteResultProps
import react.router.dom.route
import react.router.dom.switch

interface AppProps: RProps {
    var dishList: DishListState
    var couponList: CouponListState
    var accountList: AccountListState
    var orderBasket: OrderBasketState
    var activeAccount: Account?
}

interface RouteNumberResult : RProps {
    var number: String
}

fun fApp() =
    functionalComponent<AppProps> { props ->
        navbar(navItemList.filter {
            if (props.activeAccount == null)
                it.title != "Личный кабинет"
            else
                it.title != "Войти в аккаунт"
        })
        section {
            switch {
                route("/menu",
                    exact = true,
                    render = { menuContainer { } }
                )
                route("/menu/:number",
                    exact = true,
                    render = renderObject(
                        { props.dishList[it] },
                        { index, dish ->
                            dishFullContainer {
                                attrs.obj = index to dish
                            }
                        }
                    )
                )
                route("/coupon",
                    exact = true,
                    render = { couponListContainer { } }
                )
                route("/coupon/:number",
                    exact = true,
                    render = renderObject(
                        { props.couponList[it] },
                        { index, coupon ->
                            couponFullContainer {
                                attrs.obj = index to coupon
                            }
                        }
                    )
                )
                route("/news",
                    exact = true,
                    render = { news() }
                )
                route("/basket",
                    exact = true,
                    render = { basketContainer { } }
                )
                route("/account",
                    exact = true,
                    render = {
                        if (props.activeAccount == null)
                            authContainer { }
                        else
                            account()
                    }
                )
            }
        }
    }

fun <O> RBuilder.renderObject(
    selector: (Int) -> O?,
    rElement: (Int, O) -> ReactElement
) =
    { route_props: RouteResultProps<RouteNumberResult> ->
        val num = route_props.match.params.number.toIntOrNull() ?: -1
        val obj = selector(num)
        if (obj != null)
            rElement(num, obj)
        else
            p { +"Object not found" }
    }
