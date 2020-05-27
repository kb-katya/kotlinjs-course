package component.coupon

import data.Coupon
import data.Dish
import kotlinext.js.asJsObject
import kotlinx.html.classes
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface CouponAddProps : RProps {
    var createCoupon: (Coupon) -> (Event) -> Unit
    var dishList: Map<Int, Dish>
}

interface CouponAddState : RState {
    var src: String
    var code: String
    var description: String
    var foodList: Map<Int, Int>
    var price: String
}

class CouponAdd : RComponent<CouponAddProps, CouponAddState>() {

    override fun componentWillMount() {
        state.apply {
            src = ""
            code = ""
            description = ""
            price = ""
            foodList = props.dishList.map {
                it.key to 0
            }.toMap()
        }
    }

    fun RBuilder.field(label: String, value: String, placeholder: String = "", onChange: (Event) -> Unit) {
        label {
            +label
        }
        input {
            attrs.value = value
            attrs.onChangeFunction = onChange
            attrs.placeholder = placeholder
        }
    }

    fun getTarget(event: Event) = event.target?.asJsObject().unsafeCast<HTMLInputElement>()

    fun RBuilder.dishList() {
        div("any-add-dish-list") {
            h2 {
                +"Список блюд"
            }
            props.dishList.map {
                div("any-add-dish-list-item") {
                    label {
                        +it.value.title
                    }
                    button {
                        +"-"
                        attrs.onClickFunction = { event ->
                            setState {
                                foodList = foodList.toMutableMap().apply {
                                    this[it.key]?.let { count ->
                                        if (count > 0)
                                            this[it.key] = count - 1
                                    }
                                }
                            }
                        }
                    }
                    span {
                        +state.foodList[it.key].toString()
                    }
                    button {
                        +"+"
                        attrs.onClickFunction = { event ->
                            setState {
                                foodList = foodList.toMutableMap().apply {
                                    this[it.key]?.let { count ->
                                        this[it.key] = count + 1
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    val onClickCreateCoupon = {
        val onClickCreateCouponError: (Event) -> Unit = {
            console.error("Ошибка при создании купона!")
        }
        val price = state.price.toIntOrNull()
        val code = state.code.toIntOrNull()
        val foodList = state.foodList.filter {
            it.value > 0
        }
        if (price !== null && price > 0 && code !== null && code > 0 && state.code.length == 4
                && foodList.size > 0 && state.src.length > 0 && state.description.length > 0)
            props.createCoupon(Coupon(code, state.src, foodList, state.description, price))
        else
            onClickCreateCouponError
    }

    override fun RBuilder.render() {
        div("any-add") {
            h1 {
                +"Добавить новый купон"
            }
            field("Код промокода", state.code, "4 символа") {
                val target = getTarget(it)
                setState { code = target.value }
            }
            field("URL адрес изображения", state.src, "") {
                val target = getTarget(it)
                setState { src = target.value }
            }
            field("Описание", state.description, "") {
                val target = getTarget(it)
                setState { description = target.value }
            }
            field("Цена", state.price, "Цена купона в рублях") {
                val target = getTarget(it)
                setState { price = target.value }
            }
            dishList()
            button {
                +"Добавить купон"
                attrs.classes = setOf("any-add-button")
                attrs.onClickFunction = onClickCreateCoupon()
            }
        }
    }
}

fun RBuilder.couponAdd(
    createCoupon: (Coupon) -> (Event) -> Unit,
    dishList: Map<Int, Dish>
) = child(CouponAdd::class) {
    attrs.createCoupon = createCoupon
    attrs.dishList = dishList
}