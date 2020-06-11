package abc121

fun main(args: Array<String>) {
    val (A, B) = readLine()!!.split(" ").map { it.toLong() }
    fun calc(x: Long): Long {
        return when {
            x <= 0L -> 0L
            x % 2 == 1L -> if ((x + 1) / 2 % 2 == 0L) 0L else 1L
            else -> calc(x - 1) xor x
        }
    }

    println(calc(A - 1) xor calc(B))
}