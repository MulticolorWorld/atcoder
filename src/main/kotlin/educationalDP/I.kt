package educationalDP

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val p = readLine()!!.split(" ").map { it.toDouble() }.toDoubleArray()

    val dp = Array(n + 1) { DoubleArray(n + 1) }
    dp[0][0] = 1.0
    for (i in 1..n) {
        for (j in 0..i) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][j] * (1 - p[i - 1])
            } else {
                dp[i][j] = dp[i - 1][j - 1] * p[i - 1] + dp[i - 1][j] * (1 - p[i - 1])
            }
        }
    }

    var ans = 0.0
    for (i in (n / 2 + 1)..n) {
        ans += dp[n][i]
    }
    println(ans)
}