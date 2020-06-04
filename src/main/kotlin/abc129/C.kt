package abc129

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val A = IntArray(M) { readLine()!!.toInt() }
    val mod = 1000000007L

    val dp = LongArray(N + 1)
    dp[0] = 1
    if (!A.contains(1)) {
        dp[1] = 1
    }
    A.forEach {
        dp[it] = -1L
    }
    for (i in 2..N) {
        if (dp[i] != -1L) {
            dp[i] = (if (dp[i - 1] != -1L) dp[i - 1] else 0) + (if (dp[i - 2] != -1L) dp[i - 2] else 0)
            dp[i] = dp[i] % mod
        }
    }
    println(dp[N])
}