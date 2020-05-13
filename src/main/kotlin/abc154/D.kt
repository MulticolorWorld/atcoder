package abc154

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val p = readLine()!!.split(" ").map { it.toInt() }

    val eSum = DoubleArray(n + 1)
    for (i in 0 until n) {
        eSum[i + 1] = eSum[i] + (p[i] + 1) / 2.0
    }
    var max = 0.0
    for (i in 0..n - k) {
        max = Math.max(max, eSum[i + k] - eSum[i])
    }
    println(max)
}