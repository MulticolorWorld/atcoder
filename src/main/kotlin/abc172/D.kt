package abc172

fun main() {
    val N = readLine()!!.toLong()

    var ans = 0L
    for (x in 1..N) {
        val y = N / x
        val g = y * (y + 1) * x / 2
        ans += g
    }

    println(ans)
}