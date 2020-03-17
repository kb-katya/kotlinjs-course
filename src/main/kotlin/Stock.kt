import react.*
import react.dom.*
import kotlinx.html.id


fun RBuilder.rstock() =
    child(
        functionalComponent<RProps> {
            h1 {
                +"Акции"
            }
            div {
                attrs.id = "stock"
                div {
                    h1 {
                        +"Новогодний басект"
                    }
                    +"Ограниченная серия новогодних баскетов в уникальном дизайне"
                }
                div {
                    h1 {
                        +"Для тех, кто рулит"
                    }
                    +"Получай подарки с картой Автоклуба KFC"
                }
            }

        }
    ) { }