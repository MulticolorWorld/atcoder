package abc107

import java.lang.Math.abs
import java.lang.Math.min

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val X = readLine()!!.split(" ").map { it.toLong() }

    var min = Long.MAX_VALUE / 10
    for (i in 0..N - K) {
        min = min(min, abs(X[i]) + abs(X[i] - X[i + K - 1]))
        min = min(min, abs(X[i + K - 1]) + abs(X[i] - X[i + K - 1]))
    }
    println(min)
}