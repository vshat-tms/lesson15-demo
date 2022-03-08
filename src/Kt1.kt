fun main() = "Т 9 нбсуб, ежгшполй!"
    .map { if (it in " ,!") it else it - 1 }
    .forEach(::print)

fun main2() {
    val list = listOf("hello", "world", "!")

    val action = object : KotlinAction<String> {
        override fun doSomething(data: String) {
            println(data)
        }
    }



    kotlinForEachLambda(list) { println("From kotlin lamda: $it") }

//    kotlinForEach(list, action)

}

inline fun kotlinForEach(item: List<String>, action: KotlinAction<String>) {
    for (s in item) {
        action.doSomething(s)
    }
}

inline fun kotlinForEachLambda(item: List<String>, action: (String) -> Unit) {
    for (s in item) {
        action(s)
    }
}

interface KotlinAction<T> {
    fun doSomething(data: T)
}

