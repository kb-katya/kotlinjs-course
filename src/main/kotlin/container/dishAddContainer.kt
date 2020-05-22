
import component.dish.DishAdd
import component.dish.DishAddProps
import data.Dish
import data.State
import org.w3c.dom.events.Event
import react.RClass
import react.RProps
import react.invoke
import react.redux.rConnect
import redux.CreateDish
import redux.RAction
import redux.WrapperAction
import kotlin.browser.window

interface DishAddDispatchProps : RProps {
    var createDish: (Dish) -> (Event) -> Unit
}

interface DishAddStateProps : RProps

val dishAddContainer =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            DishAddStateProps,
            DishAddDispatchProps,
            DishAddProps
            >(
        mapStateToProps = { state, _ -> },
        mapDispatchToProps = { dispatch, _ ->
            createDish = { dish ->
                {
                    dispatch(CreateDish(dish))
                    window.history.back()
                }
            }
        }
    )(
        DishAdd::class.js.unsafeCast<RClass<DishAddProps>>()
    )