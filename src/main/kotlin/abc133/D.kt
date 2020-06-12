package abc133

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }

    val ans = LongArray(N)
    var t = 0L
    for (i in 0 until N) {
        if (i % 2 == 0) {
            t += A[i]
        } else {
            t -= A[i]
        }
    }
    ans[0] = t
    for (i in 1 until N) {
        ans[i] = 2 * A[i - 1] - ans[i - 1]
    }

    println(ans.joinToString(separator = " "))
}