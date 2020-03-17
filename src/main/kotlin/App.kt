import react.*
import react.dom.section


interface RAppState : RState {
    var activeTab: Int
}

class RApp : RComponent<RProps, RAppState>() {

    init {
        state.apply {
            activeTab = 0
        }
    }

    override fun RBuilder.render() {
        rnavbar { index: Int ->
            setState {
                activeTab = index
            }
        }
        section {
            if (state.activeTab == 0)
                rmenu()
            else if (state.activeTab == 1)
                rstock()
            else if (state.activeTab == 2)
                rcoupon()
        }
    }
}

fun RBuilder.rapp() =
    child(RApp::class) { }