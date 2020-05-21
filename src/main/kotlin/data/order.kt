package data

import kotlin.js.Date

data class Order (
    val accountId: Int,
    val foodList: Map<String, Int>,
    val orderPrice: Int,
    val data: Date = Date()
)