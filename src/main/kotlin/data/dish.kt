package data

data class Dish (
    val title: String,
    val scr: String,
    val type: String
)

val dishList =
    arrayListOf(
        Dish("Двойной Темный Бургер", "https://s82079.cdn.ngenix.net/Rb4UfJ9M2Po9irsvXm8si2ni.png?dw=230", "бургер"),
        Dish("Темный Бургер", "https://s82079.cdn.ngenix.net/NFHqfWBrsJT22PXKv8XDUAAc.png?dw=230", "бургер"),
        Dish("Чизбургер Де Люкс", "https://s82079.cdn.ngenix.net/1eKMTpqmU4kfM7CXsJZc3VWF.png?dw=230", "бургер"),
        Dish("Шефбургер острый", "https://s82079.cdn.ngenix.net/nyt79dy2gTrx5v595yXYuXAr.png?dw=230", "бургер"),
        Dish("Хот-дог куриный", "https://s82079.cdn.ngenix.net/uPXfsK2HtAqrJ611E6QSYXoL.png?dw=230", "бургер")
    )