package educationalDP

import java.lang.Math.max

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val happiness = Array(n) { IntArray(3) }
    for (i in 0 until n) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        happiness[i] = tmp
    }

    val dp = Array(n) { IntArray(3) }
    dp[0][0] = happiness[0][0]
    dp[0][1] = happiness[0][1]
    dp[0][2] = happiness[0][2]

    for (i in 1 until n) {
        dp[i][0] = max(dp[i - 1][1], dp[i - 1][2]) + happiness[i][0]
        dp[i][1] = max(dp[i - 1][2], dp[i - 1][0]) + happiness[i][1]
        dp[i][2] = max(dp[i - 1][0], dp[i - 1][1]) + happiness[i][2]
    }

    println(dp.last().max())
}