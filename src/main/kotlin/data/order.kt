package data

data class Order (
    val accountId: Int,
    val foodList: HashMap<Int, Int>,
    val orederPrice: Int
)