package past3rd

import kotlin.math.min

fun main() {
    val (N, L) = readLine()!!.split(" ").map { it.toInt() }
    val X = BooleanArray(L + 1)
    readLine()!!.split(" ").map { it.toInt() }.forEach {
        X[it] = true
    }
    val (T1, T2, T3) = readLine()!!.split(" ").map { it.toInt() }

    val dp = LongArray(L + 5) { Long.MAX_VALUE }
    val d = LongArray(L + 5) { Long.MAX_VALUE }
    dp[0] = 0
    d[0] = 0
    for (i in 0 until L) {
        //ハードルがある場合
        dp[i] = dp[i] + if (X[i]) T3 else 0
        //行動1
        dp[i + 1] = min(dp[i + 1], dp[i] + T1)
        d[i + 1] = min(d[i + 1], dp[i + 1])
        //行動2
        dp[i + 2] = min(dp[i + 2], dp[i] + T1 + T2)
        d[i + 1] = min(d[i + 1], dp[i] + (T1 / 2) + (T2 / 2))
        d[i + 2] = min(d[i + 2], dp[i + 2])
        //行動3
        dp[i + 4] = min(dp[i + 4], dp[i] + T1 + T2 * 3)
        d[i + 1] = min(d[i + 1], dp[i] + (T1 / 2) + (T2 / 2))
        d[i + 2] = min(d[i + 2], dp[i] + (T1 / 2) + (3 * T2 / 2))
        d[i + 3] = min(d[i + 3], dp[i] + (T1 / 2) + (5 * T2 / 2))
        d[i + 4] = min(d[i + 4], dp[i + 4])
    }
    println(d[L])
}