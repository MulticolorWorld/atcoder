package educationalDP

fun main(array: Array<String>) {
    val mod = (1e9 + 7).toLong()
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(h) { Array(w) { "" } }
    for (i in 0 until h) {
        a[i] = readLine()!!.map { it.toString() }.toTypedArray()
    }

    val dp = Array(h) { LongArray(w) }
    for (i in 0 until h) {
        for (j in 0 until w) {
            when {
                i == 0 && j == 0 -> {
                    dp[i][j] = 1
                }
                a[i][j] == "#" -> {
                    dp[i][j] = 0
                }
                i == 0 -> {
                    dp[i][j] = dp[i][j - 1]
                }
                j == 0 -> {
                    dp[i][j] = dp[i - 1][j]
                }
                else -> {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod
                }
            }
        }
    }

    println(dp[h - 1][w - 1])
}