package agc17

fun main(args: Array<String>) {
    val (N, P) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toInt() % 2 }

    val dp = Array(N + 1) { LongArray(2) }
    dp[0][0] = 1L
    dp[0][1] = 0L
    for (i in 1..N) {
        if (A[i - 1] == 0) {
            dp[i][0] = dp[i - 1][0] * 2
            dp[i][1] = dp[i - 1][1] * 2
        } else {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1]
        }
    }
    println(dp[N][P])
}