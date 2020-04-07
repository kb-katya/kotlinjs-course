import data.Dish
import data.dishList
import react.*
import react.dom.section


interface RAppState : RState {
    var activeTab: Int
    var basket: ArrayList<Dish>
}

class RApp : RComponent<RProps, RAppState>() {

    init {
        state.apply {
            activeTab = 0
            basket = arrayListOf()
        }
    }

    val onClickAddDish = {
        index: Int ->
            setState {
                basket.plusAssign(dishList[index])
            }
    }

    val onClickRemoveDish = {
        index: Int ->
            setState {
                basket.removeAt(index)
            }
    }


    override fun RBuilder.render() {
        fnavbar { index: Int ->
            setState {
                activeTab = index
            }
        }
        section {
            if (state.activeTab == 0)
                fmenu(onClickAddDish)
            else if (state.activeTab == 1)
                fstock()
            else if (state.activeTab == 2)
                fcoupon()
            else if (state.activeTab == 3)
                fbasket(state.basket, onClickRemoveDish)
        }
    }
}

fun RBuilder.rapp() =
    child(RApp::class) { }