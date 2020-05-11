package abc59

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }

    val dp = Array(n) { Array(2) { Pair(0L, 0L) } }
    when {
        a[0] > 0L -> {
            dp[0][0] = Pair(0, a[0])
            dp[0][1] = Pair(Math.abs(a[0]) + 1, -1)
        }
        a[0] == 0L -> {
            dp[0][0] = Pair(1, 1)
            dp[0][1] = Pair(1, -1)
        }
        a[0] < 0L -> {
            dp[0][0] = Pair(Math.abs(a[0]) + 1, 1)
            dp[0][1] = Pair(0, a[0])
        }
    }

    for (i in 1 until n) {
        // j -> 0
        when {
            dp[i - 1][1].second + a[i] > 0L -> {
                dp[i][0] = Pair(dp[i - 1][1].first, dp[i - 1][1].second + a[i])
            }
            dp[i - 1][1].second + a[i] == 0L -> {
                dp[i][0] = Pair(dp[i - 1][1].first + 1, 1)
            }
            dp[i - 1][1].second + a[i] < 0L -> {
                dp[i][0] = Pair(dp[i - 1][1].first + Math.abs(dp[i - 1][1].second + a[i]) + 1, 1)
            }
        }
        // j -> 1
        when {
            dp[i - 1][0].second + a[i] > 0L -> {
                dp[i][1] = Pair(dp[i - 1][0].first + Math.abs(dp[i - 1][0].second + a[i]) + 1, -1)
            }
            dp[i - 1][0].second + a[i] == 0L -> {
                dp[i][1] = Pair(dp[i - 1][0].first + 1, -1)
            }
            dp[i - 1][0].second + a[i] < 0L -> {
                dp[i][1] = Pair(dp[i - 1][0].first, dp[i - 1][0].second + a[i])
            }
        }
    }
    println(Math.min(dp[n - 1][0].first, dp[n - 1][1].first))
}