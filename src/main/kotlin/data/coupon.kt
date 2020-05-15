package data

data class Coupon (
    val code: Int,
    val foodList: HashMap<Int, Int>,
    val discription: String,
    val price: Int
)

val couponList =
    arrayListOf(
        Coupon(1455, hashMapOf(1 to 2, 2 to 1), "1455", 269),
        Coupon(1456, hashMapOf(3 to 2, 2 to 1), "1456", 299)
    ).mapIndexed { index, coupon -> index to coupon }.toMap()