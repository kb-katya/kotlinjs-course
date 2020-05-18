package redux

import data.*
import enums.*

class ChangeActiveTypeDish(val typeDish: TypeDish) : RAction

class CreateAccount(val account: Account) : RAction

class SetActiveAccount(val account: Account?) : RAction

class AddDishOrCouponToBasket(val id: String, val count: Int) : RAction