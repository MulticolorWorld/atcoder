package abc138

import java.util.*

fun main(args: Array<String>) {
    val (N, Q) = readLine()!!.split(" ").map(String::toInt)
    val g = Array(N + 1) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (A, B) = readLine()!!.split(" ").map(String::toInt)
        g[A].add(B)
        g[B].add(A)
    }

    val points = IntArray(N + 1)
    repeat(Q) {
        val (P, X) = readLine()!!.split(" ").map(String::toInt)
        points[P] += X
    }

    val queue = ArrayDeque(listOf(1))
    val visited = BooleanArray(N + 1) { false }
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        visited[cur] = true
        g[cur].forEach {
            if (!visited[it]) {
                points[it] += points[cur]
                queue.add(it)
            }
        }
    }
    println(points.slice(1..N).joinToString(separator = " "))
}