package abc168

import java.util.*

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val g = Array(N + 1) { mutableListOf<Int>() }
    for (i in 0 until M) {
        val (A, B) = readLine()!!.split(" ").map { it.toInt() }
        g[A].add(B)
        g[B].add(A)
    }
    val visited = BooleanArray(N + 1) { false }
    val before = IntArray(N + 1)
    before[1] = 0
    val queue = ArrayDeque<Int>()
    queue.add(1)
    visited[1] = true
    while (queue.isNotEmpty()) {
        val e = queue.poll()
        g[e].forEach {
            if (!visited[it]) {
                queue.add(it)
                before[it] = e
                visited[it] = true
            }
        }
    }
    println("Yes")
    for (i in 2..N) {
        println(before[i])
    }
}