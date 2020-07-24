package abc172

fun main() {
    val (N, M, K) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toInt() }
    val B = readLine()!!.split(" ").map { it.toInt() }
    val ASum = LongArray(A.size + 1)
    for (i in A.indices) {
        ASum[i + 1] = A[i] + ASum[i]
    }
    val BSum = LongArray(B.size + 1)
    for (i in B.indices) {
        BSum[i + 1] = B[i] + BSum[i]
    }
    var max = 0
    for (i in 0..A.size) {
        val readA = ASum[i]
        if (K - readA < 0) {
            continue
        }
        val j = BSum.binarySearch(K - readA)
        max = kotlin.math.max(max, i + j - 1)
    }
    println(max)
}

fun LongArray.binarySearch(key: Long): Int {
    var l = -1
    var r = this.size
    while (r - l > 1) {
        val m = l + (r - l) / 2
        if (this[m] > key) {
            r = m
        } else {
            l = m
        }
    }
    return r
}