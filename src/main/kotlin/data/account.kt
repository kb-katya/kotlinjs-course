package data

data class Account (
    var name: String,
    val phoneNumber: String,
    val password: String,
    var numberOfPoints: Int = 0,
    val isAdmin: Boolean = false
)

val accountList = mapOf(0 to Account("Admin", "88005553535", "AdminPassword", isAdmin = true))