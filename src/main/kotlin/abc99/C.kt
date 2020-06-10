package abc99

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val dp = LongArray(N + 1) { i -> i.toLong() }
    for (i in 0 until N) {
        // 6の処理
        var m = 6
        while (true) {
            if (i + m in 0..N) {
                dp[i + m] = Math.min(dp[i + m], dp[i] + 1)
                m *= 6
            } else {
                break
            }
        }
        // 9の処理
        m = 9
        while (true) {
            if (i + m in 0..N) {
                dp[i + m] = Math.min(dp[i + m], dp[i] + 1)
                m *= 9
            } else {
                break
            }
        }
    }
    println(dp[N])
}