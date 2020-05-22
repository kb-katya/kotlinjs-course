package redux

import data.*
import enums.*

class ChangeActiveTypeDish(val typeDish: TypeDish) : RAction

class CreateAccount(val account: Account) : RAction

class SetActiveAccount(val account: Pair<Int, Account>?) : RAction

class AddDishOrCouponToBasket(val id: String, val count: Int) : RAction

class ResetBasket() : RAction

class SubmitBasket(val order: Order) : RAction

class CreateCoupon(val coupon: Coupon) : RAction

class CreateDish(val dish: Dish) : RAction