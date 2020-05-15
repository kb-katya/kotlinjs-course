package redux

import data.*
import enums.TypeDish
import util.*

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
        else -> state
    }

fun newsListReducer(state: NewsListState = mapOf(), action: RAction) =
    when (action) {
        else -> state
    }

fun workFormListReducer(state: WorkFormListState = mapOf(), action: RAction) =
    when (action) {
        else -> state
    }

fun orderListReducer(state: OrderListState = mapOf(), action: RAction) =
    when (action) {
        is AddDishToBasket -> state
        else -> state
    }

fun orderBasketReducer(state: OrderBasketState = mapOf(), action: RAction) =
    when (action) {
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

fun rootReducer() = combineReducers(
    mapOf(
        State::dishList to ::dishListReducer,
        State::couponList to ::couponListReducer,
        State::accountList to ::accountListReducer,
        State::newsList to ::newsListReducer,
        State::workFormList to ::workFormListReducer,
        State::orderList to ::orderListReducer,
        State::orderBasket to ::orderBasketReducer,
        State::activeAccount to ::activeAccountReducer,
        State::activeTypeDish to ::activeTypeDishReducer
    )
)

//fun rootReducer(state: State, action: RAction) =
//    when (action) {
//        else ->
//            State(
//                dishListReducer(state.dishList, action),
//                couponListReducer(state.couponList, action),
//                accountListReducer(state.accountList, action),
//                newsListReducer(state.newsList, action),
//                workFormListReducer(state.workFormList, action),
//                orderListReducer(state.orderList, action),
//                orderBasketReducer(state.orderBasket, action),
//                activeAccountReducer(state.activeAccount, action),
//                activeTypeDishReducer(state.activeTypeDish, action)
//            )
//    }