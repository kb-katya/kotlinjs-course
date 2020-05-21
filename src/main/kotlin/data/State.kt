package data

import enums.TypeDish

typealias DishListState = Map<Int, Dish>

typealias CouponListState = Map<Int, Coupon>

typealias AccountListState = Map<Int, Account>

typealias OrderListState = Map<Int, Order>

typealias OrderBasketState = Map<String, Int>

typealias ActiveAccountState = Pair<Int, Account>?

typealias ActiveTypeDishState = TypeDish

data class State(
    val dishList: DishListState,
    val couponList: CouponListState,
    val accountList: AccountListState,
    val orderList: OrderListState,
    val orderBasket: OrderBasketState,
    val activeAccount: ActiveAccountState,
    val activeTypeDish: ActiveTypeDishState
)

fun <T> Map<Int, T>.newId() =
    (this.maxBy { it.key }?.key ?: 0) + 1

fun initialState() =
    State(
        dishList,
        couponList,
        mapOf(),
        mapOf(),
        mapOf(),
        null,
        TypeDish.Burger
    )