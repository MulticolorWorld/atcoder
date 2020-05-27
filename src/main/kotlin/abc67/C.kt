package abc67

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }.toLongArray()
    val revA = A.reversedArray()

    val l = LongArray(N + 1)
    val r = LongArray(N + 1)
    for (i in 1..N) {
        l[i] = A[i - 1] + l[i - 1]
        r[i] = revA[i - 1] + r[i - 1]
    }

    var min = Long.MAX_VALUE / 10
    for (i in 1 until N) {
        min = Math.min(min, Math.abs(l[i] - r[N - i]))
    }
    println(min)
}