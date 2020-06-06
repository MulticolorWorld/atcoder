package past3rd

fun main() {
    val s = readLine()!!
    val t = readLine()!!
    when {
        s == t -> "same"
        s.toLowerCase() == t.toLowerCase() -> "case-insensitive"
        else -> "different"

    }.let { println(it) }
}