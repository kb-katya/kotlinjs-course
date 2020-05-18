package data

data class Coupon (
    val code: Int,
    val src: String,
    val foodList: HashMap<Int, Int>,
    val description: String,
    val price: Int
)

val couponList =
    arrayListOf(
        Coupon(1455, "https://s82079.cdn.ngenix.net/dWQPpsiRNQHitjxHLFQGwvu3.png?dw=230&dh=230",
            hashMapOf(1 to 2, 2 to 1), "Шефбургер Джуниор + картофель фри стандартный + Капучино", 199),
        Coupon(1456, "https://s82079.cdn.ngenix.net/1fvx7YSyyx92rPuM11zXjhSf.png?dw=230&dh=230",
            hashMapOf(1 to 2, 2 to 1), "3 Стрипса ор./ост. + Соус сырный", 109)
    ).mapIndexed { index, coupon -> index to coupon }.toMap()