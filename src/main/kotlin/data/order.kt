package data

data class Order (
    val accountId: Int,
    val foodList: HashMap<String, Int>,
    val orderPrice: Int
)