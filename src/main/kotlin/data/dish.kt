package data
import enums.TypeDish

data class Dish (
    val title: String,
    val scr: String,
    val type: TypeDish,
    val discription: String,
    val price: Int
)

val burgerList =
    arrayListOf(
        Dish(
            "Двойной Темный Бургер",
            "https://s82079.cdn.ngenix.net/Rb4UfJ9M2Po9irsvXm8si2ni.png?dw=230",
            TypeDish.Burger,
            "Невероятно большой бургер в KFC с нежнейшим мясом бедра цыпленка: два филе на ароматной ржаной" +
                    " булочке с соусом барбекю, свежими овощами, сыром чеддер и эмменталер, маринованными огурчиками и халапеньо.",
            259
        ),
        Dish(
            "Темный Бургер",
            "https://s82079.cdn.ngenix.net/NFHqfWBrsJT22PXKv8XDUAAc.png?dw=230",
            TypeDish.Burger,
            "Бургер с нежнейшим мясом бедра цыпленка в KFC, с соусом барбекю, свежими овощами, сыром чеддер" +
                    " и эмменталер, маринованными огурчиками и халапеньо на ароматной ржаной булочке.",
            169
        ),
        Dish(
            "Чизбургер Де Люкс",
            "https://s82079.cdn.ngenix.net/1eKMTpqmU4kfM7CXsJZc3VWF.png?dw=230",
            TypeDish.Burger,
            "Пряный горчичный соус, кетчуп, сочное филе в оригинальной панировке, лук, сыр Чеддер, огурцы на" +
                    " пшеничной булочке с кукурузной посыпкой, свежий салат и ломтики помидора. Попробуйте в KFC.",
            124
        ),
        Dish(
            "Шефбургер Де Люкс острый",
            "https://s82079.cdn.ngenix.net/nyt79dy2gTrx5v595yXYuXAr.png?dw=230",
            TypeDish.Burger,
            "Острый бургер от шефа теперь де Люкс в KFC! Острое филе в хрустящей панировке, салат айсберг, " +
                    "маринованные огурцы, лук, фирменный соус «Бургер», булочка с кунжутом, ломтик сыра и два ломтика бекона.",
            144
        )
    )

val basketList =
    arrayListOf(
        Dish(
            "Сандерс Баскет",
            "https://kfc-burgers.ru/wp-content/uploads/2019/05/Sanders-Basket-e1558533822696.png",
            TypeDish.Basket,
            "Баскет от Полковника Сандерса! Что входит: Ножка, 2 крыла, 2 стрипса, 6 байтс в KFC.",
            199
        )
    )

val dishList = (burgerList + basketList).mapIndexed { index, dish -> index to dish }.toMap()