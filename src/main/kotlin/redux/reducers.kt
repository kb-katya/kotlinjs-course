package redux

import data.*
import enums.TypeDish

fun dishListReducer(state: DishListState = mapOf(), action: RAction) =
    when (action) {
        else -> state
    }

fun couponListReducer(state: CouponListState = mapOf(), action: RAction) =
    when (action) {
        else -> state
    }

fun accountListReducer(state: AccountListState = mapOf(), action: RAction) =
    when (action) {
        is CreateAccount -> state.plus(state.newId() to action.account)
        is SubmitBasket -> state.toMutableMap().apply {
            this[action.order.accountId]!!.apply {
                this.numberOfPoints = (action.order.orderPrice * 0.10).toInt()
            }
        }
        else -> state
    }

fun orderListReducer(state: OrderListState = mapOf(), action: RAction) =
    when (action) {
        is SubmitBasket -> state + (state.newId() to action.order)
        else -> state
    }

fun orderBasketReducer(state: OrderBasketState = mapOf(), action: RAction) =
    when (action) {
        is AddDishOrCouponToBasket -> state.toMutableMap().apply {
            if (this[action.id] == null)
                this[action.id] = action.count
            else
                this[action.id]?.let {
                    this[action.id] = it + action.count
                }
        }
        is ResetBasket -> mapOf()
        is SubmitBasket -> mapOf()
        else -> state
    }

fun activeAccountReducer(state: ActiveAccountState = null, action: RAction) =
    when (action) {
        is SetActiveAccount -> action.account
        else -> state
    }

fun activeTypeDishReducer(state: ActiveTypeDishState = TypeDish.Burger, action: RAction) =
    when (action) {
        is ChangeActiveTypeDish -> action.typeDish
        else -> state
    }

fun rootReducer(state: State, action: RAction) =
    State(
        dishListReducer(state.dishList, action),
        couponListReducer(state.couponList, action),
        accountListReducer(state.accountList, action),
        orderListReducer(state.orderList, action),
        orderBasketReducer(state.orderBasket, action),
        activeAccountReducer(state.activeAccount, action),
        activeTypeDishReducer(state.activeTypeDish, action)
    )