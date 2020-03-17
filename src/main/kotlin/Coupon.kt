import react.*
import react.dom.*
import kotlinx.html.id


fun RBuilder.rcoupon() =
    child(
        functionalComponent<RProps> {
            div {
                attrs.id = "coupon"
                div {
                    h1 {
                        +"3072"
                    }
                    +"3 Стрипса ор./ост. + Соус сырный\n"
                }
            }
        }
    ) { }