package data

data class Coupon (
    val code: Int,
    val src: String,
    val foodList: Map<Int, Int>,
    val description: String,
    val price: Int
)

val couponList =
    arrayListOf(
        Coupon(3990, "https://s82079.cdn.ngenix.net/dWQPpsiRNQHitjxHLFQGwvu3.png?dw=230&dh=230",
            mapOf(0 to 1, 14 to 1, 15 to 1), "Шефбургер Джуниор + картофель фри стандартный + Капучино", 199),
        Coupon(3072, "https://s82079.cdn.ngenix.net/1fvx7YSyyx92rPuM11zXjhSf.png?dw=230&dh=230",
            mapOf(6 to 1, 12 to 1), "3 Стрипса + Соус сырный", 109),
        Coupon(4037, "https://s82079.cdn.ngenix.net/UBkziq77yzjKNScXE7GoaeLM.png?dw=230&dh=230",
            mapOf(14 to 2, 12 to 2), "2 Картофеля Фри стандартных + 2 соуса сырных", 119)
    ).mapIndexed { index, coupon -> index to coupon }.toMap()