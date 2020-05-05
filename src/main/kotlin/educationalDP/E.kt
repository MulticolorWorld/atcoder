package educationalDP

import java.lang.Math.min
import java.lang.Math.pow

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(" ").map { it.toInt() }
    val weight = IntArray(n)
    val value = IntArray(n)
    for (i in 0 until n) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        weight[i] = tmp[0]
        value[i] = tmp[1]
    }
    val vSum = value.sum()

    val dp = Array(n + 1) { LongArray(vSum + 1) { pow(10.0, 10.0).toLong() } }
    dp[0][0] = 0L

    for (i in 0 until n) {
        for (j in 0 until vSum + 1) {
            if (j - value[i] >= 0) {
                dp[i + 1][j] = min(dp[i][j - value[i]] + weight[i], dp[i][j])
            } else {
                dp[i + 1][j] = dp[i][j]
            }
        }
    }

    var min = 0
    for (i in dp[n].indices) {
        if (dp[n][i] <= w) min = i
    }
    println(min)
}