package data

data class Account (
    var name: String,
    val phoneNumber: String,
    val password: String,
    var numberOfPoints: Int = 0,
    val isAdmin: Boolean = false
)