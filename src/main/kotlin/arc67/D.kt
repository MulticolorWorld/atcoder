package arc67

fun main(args: Array<String>) {
    val (N, A, B) = readLine()!!.split(" ").map { it.toLong() }
    val X = readLine()!!.split(" ").map { it.toLong() }

    var ans = 0L
    for (i in 1 until N.toInt()) {
        ans += Math.min(B, (X[i] - X[i - 1]) * A)
    }
    println(ans)
}