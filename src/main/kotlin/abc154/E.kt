package abc154

fun main(args: Array<String>) {
    val N = "0" + readLine()!!
    val K = readLine()!!.toInt()
    val dp = Array(N.length + 1) { Array(2) { LongArray(K + 2) } }

    dp[0][0][0] = 1L

    for (i in 1 until N.length) {
        for (k in 0..K) {
            //遷移元が最大値の場合を先にやる
            if (N[i] != '0') {
                dp[i][0][k + 1] += dp[i - 1][0][k] //最大値を追加 遷移先も最大値
                dp[i][1][k] += dp[i - 1][0][k] //0を追加 遷移先はもう最大値ではない
                dp[i][1][k + 1] += dp[i - 1][0][k] * (N[i].toString().toInt() - 1) //1から最大値未満を追加 遷移先はもう最大値ではない
            } else {
                dp[i][0][k] += dp[i - 1][0][k] //0しか追加できない 遷移先も最大値
            }
            //遷移元が最大値でないので遷移先も最大値ではない
            dp[i][1][k] += dp[i - 1][1][k] //0を追加
            dp[i][1][k + 1] += dp[i - 1][1][k] * 9 //0以外を追加
        }
    }
    println(dp[N.length - 1][1][K] + dp[N.length - 1][0][K]) //答えは最大値の場合と最大値でない場合を足す
}