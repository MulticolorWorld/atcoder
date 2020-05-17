package abc168

fun main() {
    val n = readLine()!!
    when (n.last()) {
        '0', '1', '6', '8' -> "pon"
        '2', '4', '5', '7', '9' -> "hon"
        else -> "bon"
    }.let {
        println(it)
    }
}