package data

data class Tab (
    val title: String
)

val tabList =
    arrayListOf(
        Tab("Меню"),
        Tab("Акции"),
        Tab("Купоны"),
        Tab("Корзина")
    )