package data
import enums.TypeDish

data class Dish (
    val title: String,
    var src: String,
    val type: TypeDish,
    var description: String,
    var price: Int
)

val burgerList =
    arrayListOf(
        Dish(
            "Шефбургер Джуниор",
            "https://s82079.cdn.ngenix.net/Jtt1xXNpgBaXhvbXXgNzJCSo.png?dw=230",
            TypeDish.Burger,
            "Нежный сливочный соус, два сочных стрипса в оригинальной панировке, салат айcберг и помидоры на пшеничной булочке с черно-белым кунжутом.",
            99
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

val twisterList =
    arrayListOf(
        Dish(
            "Боксмастер со Cтрипсами",
            "https://s82079.cdn.ngenix.net/WKThQRtyGbaVEpNzCtAP5z2H.png?dw=230",
            TypeDish.Twister,
            "Полная перезагрузка! Мощный заряд энергии в нашем БоксМастере!",
            194
        ),
        Dish(
            "Твистер Джуниор",
            "https://s82079.cdn.ngenix.net/7eM97nAz7pXzSbTNHPaC76VT.png?dw=230",
            TypeDish.Twister,
            "Сырная лепешка, два сочных оригинальных стрипса из куриного филе в панировке, горчица, кетчуп, сыр, маринованные огурчики и лук – идеальный перекус!",
            99
        )
    )

val chickenList =
    arrayListOf(
        Dish(
            "Стрипсы оригинальные",
            "https://s82079.cdn.ngenix.net/MTnB3ERP1htqWFwPo99GF3Vd.png?dw=230",
            TypeDish.Chicken,
            "Только любимый вкус – и ничего лишнего. Потрясающе нежное куриное филе мы панируем вручную и готовим в ресторане по уникальному рецепту Полковника Сандерса.",
            104
        ),
        Dish(
            "Крылья",
            "https://s82079.cdn.ngenix.net/6si9VMChyE26A1xocz5fsi8K.png?dw=230",
            TypeDish.Chicken,
            "Огонь внутри! Далеко не ангельские крылья*! Наши острые куриные крылья в хрустящей панировке со жгучими специями – настоящий огонь!",
            124
        )
    )

val basketList =
    arrayListOf(
        Dish(
            "Сандерс Баскет",
            "https://s82079.cdn.ngenix.net/fKaj94jqdwqqtbvvsaZkRkaW.png?dw=230",
            TypeDish.Basket,
            "Баскет от Полковника Сандерса! Что входит: Ножка, 2 крыла, 2 стрипса, 6 байтс в KFC.",
            199
        ),
        Dish(
            "Баскет Дуэт с Острыми Стрипсами",
            "https://s82079.cdn.ngenix.net/EzBv7o1KZJH31f1wLznix1hF.png?dw=230",
            TypeDish.Basket,
            "Всемирно известные хиты от KFC в нашем Баскете! Для вас мы собрали отличную компанию – сочные кусочки курицы, обжигающе острые крылья, нежнейшие стрипсы и картофель фри.",
            409
        )
    )

val sauceList =
    arrayListOf(
        Dish(
            "Соус Барбекю",
            "https://s82079.cdn.ngenix.net/LSwBJ3tkUKdSmx8uVLRxtv6V.png?dw=230",
            TypeDish.Sauce,
            "Аппетитный соус барбекю с насыщенным многогранным вкусом и нотками копченостей.",
            27
        ),
        Dish(
            "Соус Чесночный",
            "https://s82079.cdn.ngenix.net/EoivuYE2HVRchbduDsfoVY84.png?dw=230",
            TypeDish.Sauce,
            "Пикантный острый соус с насыщенным ароматом, отлично дополняющий вкус как мясных, так и овощных блюд.",
            27
        ),
        Dish(
            "Соус Cырный",
            "https://s82079.cdn.ngenix.net/Q6kee5BPTeAR2hf68nAb9w9K.png?dw=230",
            TypeDish.Sauce,
            "Сырный соус прекрасно подходит к блюдам из птицы и запеченному картофелю.",
            27
        )
    )

val snacksList =
    arrayListOf(
        Dish(
            "Картофель Фри Малый",
            "https://s82079.cdn.ngenix.net/BT6dy8qxuHpJsnA6jqT6T5in.png?dw=230",
            TypeDish.Snacks,
            "Еще больше вкуса! В наших крупных ломтиках мы сохранили еще больше вкуса твоего любимого картофеля фри. Он получается именно таким, как ты любишь – с аппетитно хрустящей корочкой и мягкой, рассыпчатой серединкой. Любимое удовольствие!",
            50
        ),
        Dish(
            "Картофель Фри Стандартный",
            "https://s82079.cdn.ngenix.net/9fh3NYyrKj4pm41ERm8jG2E6.png?dw=230",
            TypeDish.Snacks,
            "Еще больше вкуса! В наших крупных ломтиках мы сохранили еще больше вкуса твоего любимого картофеля фри. Он получается именно таким, как ты любишь – с аппетитно хрустящей корочкой и мягкой, рассыпчатой серединкой. Любимое удовольствие!",
            69
        )
    )

val drinkList =
    arrayListOf(
        Dish(
            "Кофе Капучино",
            "https://s82079.cdn.ngenix.net/E6ww5qRFgmcu8BiALW6SV6qk.png?dw=230",
            TypeDish.Drink,
            "Кофейный напиток итальянской кухни на основе эспрессо с добавлением в него подогретого вспененного молока.",
            99
        ),
        Dish(
            "Pepsi",
            "https://s82079.cdn.ngenix.net/ZofrhSx523GJDLWZXzasZabA.png?dw=230",
            TypeDish.Drink,
            "Безалкогольный газированный напиток, производимый американской компанией PepsiCo",
            75
        )
    )

val dessertList =
    arrayListOf(
        Dish(
            "Донат Яблоко-Корица",
            "https://s82079.cdn.ngenix.net/SSi3mNAZmjQp3EcLVMHSKYav.png?dw=230",
            TypeDish.Dessert,
            "Попробуй новинку: нежнейший пончик в сахарной глазури с яблочной начинкой и корицей!",
            69
        )
    )

val dishList = (burgerList + twisterList + chickenList + basketList + sauceList + snacksList + drinkList + dessertList)
    .mapIndexed { index, dish -> index to dish }.toMap()