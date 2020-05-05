package educationalDP

import java.lang.Math.max

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(" ").map { it.toInt() }
    val wv = Array(n) { IntArray(2) }
    for (i in 0 until n) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        wv[i] = tmp
    }

    val dp = Array(n + 1) { LongArray(w + 1) { 0L } }

    for (i in 0 until n) {
        for (j in 0 until w + 1) {
            if (j < wv[i][0]) {
                dp[i + 1][j] = dp[i][j]
            } else {
                dp[i + 1][j] = max(dp[i][j - wv[i][0]] + wv[i][1], dp[i][j])
            }
        }
    }

    println(dp[n][w])
}