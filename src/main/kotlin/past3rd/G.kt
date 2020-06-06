package past3rd

import java.util.*

fun main() {
    val (N, X, Y) = readLine()!!.split(" ").map { it.toInt() }

    val visited = Array(2001) { BooleanArray(2001) { false } }
    repeat(N) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        visited[x + 1000][y + 1000] = true
    }

    val next = arrayOf(Pair(1, 1), Pair(0, 1), Pair(-1, 1), Pair(1, 0), Pair(-1, 0), Pair(0, -1))
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(1000, 1000, 0))
    visited[1000][1000] = true
    while (queue.isNotEmpty()) {
        val e = queue.poll()
        if (e.first == X + 1000 && e.second == Y + 1000) {
            println(e.third)
            return
        }

        next.forEach { n ->
            val nx = e.first + n.first
            val ny = e.second + n.second
            if (nx < 0 || ny < 0 || nx > 2000 || ny > 2000) {
                return@forEach
            }
            if (!visited[nx][ny]) {
                visited[nx][ny] = true
                queue.add(Triple(nx, ny, e.third + 1))
            }
        }

    }
    println(-1)
}