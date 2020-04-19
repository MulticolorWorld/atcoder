package abc163

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    val aSum = a.sum()
    if (aSum > n) println(-1) else println(n - aSum)
}