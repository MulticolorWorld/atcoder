package abc153

fun main(args: Array<String>) {
    val (h, n) = readLine()!!.split(" ").map { it.toInt() }
    val a = IntArray(n)
    val b = IntArray(n)
    for (i in 0 until n) {
        readLine()!!.split(" ").map { it.toInt() }.let {
            a[i] = it[0]
            b[i] = it[1]
        }
    }

    val dp = IntArray(h + 1)
    for (i in 1..h) {
        dp[i] = (0 until n).map {
            dp.getOrElse(i - a[it]) { 0 } + b[it]
        }.min()!!
    }
    println(dp[h])
}


