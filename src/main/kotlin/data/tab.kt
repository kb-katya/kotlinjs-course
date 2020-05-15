package data

import enums.TypeDish

data class Tab (
    val type: TypeDish,
    val title: String
)

val tabList =
    arrayListOf(
        Tab(TypeDish.Burger, "Бургеры"),
        Tab(TypeDish.Twister, "Твистеры"),
        Tab(TypeDish.Chicken, "Курица"),
        Tab(TypeDish.Basket, "Баскеты"),
        Tab(TypeDish.Snacks, "Снэки"),
        Tab(TypeDish.Sauce, "Соусы"),
        Tab(TypeDish.Drink, "Напитки"),
        Tab(TypeDish.Dessert, "Десерты")
    )