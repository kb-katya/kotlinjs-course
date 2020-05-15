package data

data class Account (
    val name: String,
    val phoneNumber: String,
    val password: String,
    val numberOfPoints: Int = 0,
    val isAdmin: Boolean = false
)