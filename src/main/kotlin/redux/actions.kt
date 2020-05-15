package redux

import data.*
import enums.*

class ChangeActiveTypeDish(val typeDish: TypeDish) : RAction

class CreateAccount(val account: Account) : RAction

class SetActiveAccount(val account: Account?) : RAction

class AddDishToBasket(val dish_id: Int, val count: Int) : RAction