package educationalDP

import java.lang.Math.max

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!

    val dp = Array(s.length + 1) { IntArray(t.length + 1) }

    for (i in s.indices) {
        for (j in t.indices) {
            if (s[i] == t[j]) {
                dp[i + 1][j + 1] = dp[i][j] + 1
            } else {
                dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }

    var x = s.length
    var y = t.length
    var ans = ""
    while (x > 0 && y > 0) {
        when {
            dp[x][y] == dp[x][y - 1] -> {
                y--
            }
            dp[x][y] == dp[x - 1][y] -> {
                x--
            }
            else -> {
                ans += s[x - 1]
                x--
                y--
            }
        }
    }
    if (ans.isNotBlank()) println(ans.reversed())
}