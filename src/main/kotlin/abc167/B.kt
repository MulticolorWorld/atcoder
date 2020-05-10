package abc167

fun main() {
    val (a, b, c, n) = readLine()!!.split(" ").map { it.toInt() }
    if (n <= a) {
        println(n)
    } else if (a < n && n <= a + b) {
        println(a)
    } else if (a + b < n) {
        println(a - (n - (a + b)))
    }
}