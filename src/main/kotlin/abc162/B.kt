package abc162

fun main() {
    val n = readLine()!!.toInt()

    var ans = 0L
    for (i in 0 until n + 1) {
        if ((i % 3 == 0 || i % 5 == 0).not()) {
            ans += i
        }
    }
    println(ans)
}