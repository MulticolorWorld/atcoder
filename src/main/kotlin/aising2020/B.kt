package aising2020

fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }
    var ans = 0
    for (i in 0 until N) {
        if (i % 2 == 0 && A[i] % 2 == 1) ans++
    }
    println(ans)
}