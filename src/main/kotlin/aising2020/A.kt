package aising2020

fun main() {
    val (L, R, D) = readLine()!!.split(" ").map { it.toInt() }
    var ans = 0
    for (i in L..R) {
        if (i % D == 0) ans++
    }
    println(ans)
}