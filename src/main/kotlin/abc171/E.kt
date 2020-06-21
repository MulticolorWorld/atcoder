package abc171

fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }

    var s = 0L
    A.forEach { a ->
        s = s.xor(a)
    }

    val B = LongArray(N)
    for (i in 0 until N) {
        B[i] = s.xor(A[i])
    }
    println(B.joinToString(separator = " "))
}