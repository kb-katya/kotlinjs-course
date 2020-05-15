package component

import data.*
import kotlinx.html.classes
import react.*
import react.dom.*

interface NewsFullProps : RProps {
    var news: News
}

val fNewsFull =
    functionalComponent<NewsFullProps> { props ->
        div {
            attrs.classes = setOf("object-full")
            +props.news.title
        }
    }

fun RBuilder.newsFull(
    news: News
) = child(fNewsFull) {
    attrs.news = news
}