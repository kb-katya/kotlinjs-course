package component.dish

import data.Dish
import data.tabList
import enums.TypeDish
import kotlinext.js.asJsObject
import kotlinx.html.classes
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface DishAddProps : RProps {
    var createDish: (Dish) -> (Event) -> Unit
}

interface DishAddState : RState {
    var title: String
    var src: String
    var type: TypeDish
    var description: String
    var price: String
}

class DishAdd : RComponent<DishAddProps, DishAddState>() {

    init {
        state.apply {
            title = ""
            src = ""
            description = ""
            price = ""
            type = tabList[0].type
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

    val onClickCreateDish = {
        val onClickCreateDishError: (Event) -> Unit = {
            console.error("Ошибка при создании блюда!")
        }
        val price = state.price.toIntOrNull()
        if (price !== null && price > 0 && state.src.length > 0
                && state.description.length > 0 && state.title.length > 0)
            props.createDish(Dish(state.title, state.src, state.type, state.description, price))
        else
            onClickCreateDishError
    }

    fun getTarget(event: Event) = event.target?.asJsObject().unsafeCast<HTMLInputElement>()

    override fun RBuilder.render() {
        div("any-add") {
            h1 {
                +"Добавить новое блюдо"
            }
            field("Название блюда", state.title, "") {
                val target = getTarget(it)
                setState { title = target.value }
            }
            field("URL адрес изображения", state.src, "") {
                val target = getTarget(it)
                setState { src = target.value }
            }
            field("Описание", state.description, "") {
                val target = getTarget(it)
                setState { description = target.value }
            }
            field("Цена", state.price, "Цена блюда в рублях") {
                val target = getTarget(it)
                setState { price = target.value }
            }
            label {
                +"Тип блюда"
            }
            select {
                tabList.mapIndexed { index, tab ->
                    option {
                        attrs.value = index.toString()
                        +tab.title
                    }
                }
                attrs.onChangeFunction = {
                    val target = getTarget(it)
                    setState { type = tabList[target.value.toInt()].type }
                }
            }
            button {
                +"Добавить блюдо"
                attrs.classes = setOf("any-add-button")
                attrs.onClickFunction = onClickCreateDish()
            }
        }
    }
}

fun RBuilder.dishAdd(
    createDish: (Dish) -> (Event) -> Unit
) = child(DishAdd::class) {
    attrs.createDish = createDish
}