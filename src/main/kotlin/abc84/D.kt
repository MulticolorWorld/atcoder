package abc84

fun main(args: Array<String>) {
    val maxQ = 100000
    val f = BooleanArray(maxQ + 1) { true }
    f[0] = false
    f[1] = false
    for (i in 2..maxQ) {
        if (f[i]) {
            for (j in 2 * i..maxQ step i) {
                f[j] = false
            }
        }
    }
    val sum = IntArray(maxQ + 1)
    for (i in 1..maxQ) {
        sum[i] = sum[i - 1] + if (f[i] && f[(i + 1) / 2]) 1 else 0
    }

    val Q = readLine()!!.toInt()
    repeat(Q) {
        val (L, R) = readLine()!!.split(" ").map { it.toInt() }
        println(sum[R] - sum[L - 1])
    }
}