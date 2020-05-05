package educationalDP

import java.lang.Math.abs
import java.lang.Math.min

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val h = readLine()!!.split(" ").map { it.toInt() }

    val dp = IntArray(n)

    for (i in 1 until n) {
        var min = Int.MAX_VALUE
        for (j in 1 until min(i, k) + 1) {
            min = min(min, dp[i - j] + abs(h[i] - h[i - j]))
        }
        dp[i] = min
    }
    println(dp.last())
}