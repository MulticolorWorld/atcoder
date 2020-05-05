package educationalDP

import java.lang.Math.abs
import java.lang.Math.min

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val h = readLine()!!.split(" ").map { it.toInt() }

    val dp = IntArray(n)
    dp[1] = abs(h[0] - h[1])

    for (i in 2 until n) {
        dp[i] = min(abs(h[i] - h[i - 1]) + dp[i - 1], abs(h[i] - h[i - 2]) + dp[i - 2])
    }
    println(dp.last())
}

