package data

data class NavItem (
    val title: String,
    val path: String
)

val navItemList =
    arrayListOf(
        NavItem("Меню", "/menu"),
        NavItem("Купоны", "/coupon"),
        NavItem("Личный кабинет", "/account"),
        NavItem("Войти в аккаунт", "/account"),
        NavItem("Корзина", "/basket")
    )