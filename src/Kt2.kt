fun main4() = listOf(1, 2, 3, 4, 5)
    .map { it * 4 }
    .filter { it > 10 }
    .forEach(::println)



fun myForeach

fun main() {
    val result = listOf(1, 2, 3, 4, 5) + listOf(5, 6, 7)
    println(result)
    println(getUserFullName(User("Petr", "Ivanov")))
    println(User("Petr", "Ivanov").getFullName())
    println(User("Petr", "Ivanov").fullName2)
}

data class User(val firstName: String, val lastName: String) {
    fun getFullName() = firstName + " " + lastName
}

fun getUserFullName(user: User): String {
    return user.firstName + " " + user.lastName
}

fun User.getFullName(): String {
    return firstName + " " + lastName
}

val User.fullName2
    get() = firstName + " " + lastName