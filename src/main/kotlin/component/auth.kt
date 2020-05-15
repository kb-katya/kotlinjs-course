package component

import data.*
import kotlinext.js.asJsObject
import kotlinx.html.InputType
import react.*
import react.dom.*
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event

interface AuthProps : RProps {
    var accountList: Map<Int, Account>
    var login: (Account) -> (Event) -> Unit
    var registration: (Account) -> (Event) -> Unit
}

interface AuthState : RState {
    var signInPhoneNumber: String
    var signInPassword: String
    var signUpName: String
    var signUpPhoneNumber: String
    var signUpPassword: String
    var signUpConfPassword: String
}

class Auth : RComponent<AuthProps, AuthState>() {

    init {
        state.apply {
            signInPhoneNumber = ""
            signInPassword = ""
            signUpName = ""
            signUpPhoneNumber = ""
            signUpPassword = ""
            signUpConfPassword = ""
        }
    }

    fun getTarget(event: Event) = event.target?.asJsObject().unsafeCast<HTMLInputElement>()

    fun RBuilder.field(label: String, value: String, type: InputType, onChange: (Event) -> Unit) {
        label {
            +label
        }
        input {
            attrs.value = value
            attrs.onChangeFunction = onChange
            attrs.type = type
        }
    }

    val onClickLogin = {
        val account = props.accountList.filterValues {
            it.phoneNumber == state.signInPhoneNumber && it.password == state.signInPassword
        }
        val onClickLoginError: (Event) -> Unit = {
            console.error("Account not found")
        }
        if (account.isNotEmpty())
            props.login(account.get(account.keys.first())!!)
        else
            onClickLoginError
    }

    val onClickRegistration = {
        val account = props.accountList.filterValues {
            it.phoneNumber == state.signUpPhoneNumber
        }
        val onClickRegistrationError: (Event) -> Unit = {
            console.error("Registration error")
        }
        if (account.isEmpty() && state.signUpPassword == state.signUpConfPassword
            && state.signUpPassword.length > 6 && (state.signUpPhoneNumber.length == 10
            && state.signUpName.length > 2)
        )
            props.registration(
                Account(
                    state.signUpName,
                    state.signUpPhoneNumber,
                    state.signUpPassword
                )
            )
        else
            onClickRegistrationError
    }

    fun RBuilder.signIn() {
        div {
            h1 {
                +"Войти в аккаунт"
            }
            field("Номер телефона", state.signInPhoneNumber, InputType.text) {
                val target = getTarget(it)
                setState { signInPhoneNumber = target.value }
            }
            field("Пароль", state.signInPassword, InputType.password) {
                val target = getTarget(it)
                setState { signInPassword = target.value }
            }
            input {
                attrs.type = InputType.button
                attrs.value = "Войти"
                attrs.onClickFunction = onClickLogin()
            }
        }
    }

    fun RBuilder.signUp() {
        div {
            h1 {
                +"Зарегистрировать аккаунт"
            }
            field("Имя", state.signUpName, InputType.text) {
                val target = getTarget(it)
                setState { signUpName = target.value }
            }
            field("Номер телефона", state.signUpPhoneNumber, InputType.text) {
                val target = getTarget(it)
                setState { signUpPhoneNumber = target.value }
            }
            field("Пароль", state.signUpPassword, InputType.password) {
                val target = getTarget(it)
                setState { signUpPassword = target.value }
            }
            field("Подтверждение пароля", state.signUpConfPassword, InputType.password) {
                val target = getTarget(it)
                setState { signUpConfPassword = target.value }
            }
            input {
                attrs.type = InputType.button
                attrs.value = "Зарегистрироваться"
                attrs.onClickFunction = onClickRegistration()
            }
        }
    }

    override fun RBuilder.render() {
        div {
            attrs.id = "auth"
            signIn()
            signUp()
        }
    }
}

fun RBuilder.auth(
    accountList: Map<Int, Account>,
    login: (Account) -> (Event) -> Unit,
    registration: (Account) -> (Event) -> Unit
) = child(Auth::class) {
    attrs.accountList = accountList
    attrs.login = login
    attrs.registration = registration
}