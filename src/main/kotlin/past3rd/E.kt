package past3rd

fun main() {
    val (N, M, Q) = readLine()!!.split(" ").map { it.toInt() }
    val g = Array(N + 1) { mutableListOf<Int>() }
    repeat(M) {
        val (U, V) = readLine()!!.split(" ").map { it.toInt() }
        g[U].add(V)
        g[V].add(U)
    }
    val C = intArrayOf(0) + readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    repeat(Q) {
        val q = readLine()!!.split(" ").map { it.toInt() }
        if (q[0] == 1) {
            println(C[q[1]])
            g[q[1]].forEach { e ->
                C[e] = C[q[1]]
            }
        } else {
            println(C[q[1]])
            C[q[1]] = q[2]
        }
    }
}