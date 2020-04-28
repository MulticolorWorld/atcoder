package yorukatsu27

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!.toCharArray().map { it.toString() }

    val wSum = Array(n) { 0L }
    wSum[0] = if (s[0] == "W") 1 else 0
    for (i in 1 until n) {
        wSum[i] = if (s[i] == "W") wSum[i - 1] + 1 else wSum[i - 1]
    }

    val eSum = Array(n) { 0L }
    eSum[0] = if (s[0] == "E") 1 else 0
    for (i in 1 until n) {
        eSum[i] = if (s[i] == "E") eSum[i - 1] + 1 else eSum[i - 1]
    }

    var min = if (eSum[n - 1] - eSum[0] > wSum[n - 2]) wSum[n - 2] else eSum[n - 1] - eSum[0]
    for (i in 1 until n - 1) {
        val c = wSum[i - 1] + eSum[n - 1] - eSum[i]
        if (min > c) min = c
    }
    println(min)
}