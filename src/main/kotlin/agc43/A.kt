package agc43

import java.util.*

fun main(args: Array<String>) {
    val (H, W) = readLine()!!.split(" ").map { it.toInt() }
    val S = Array(H) { readLine()!! }

    val d = Array(H) { IntArray(W) { Int.MAX_VALUE / 10 } }
    val queue = PriorityQueue<Triple<Int, Int, Int>>(H * W, compareBy { it.third })
    if (S[0][0] == '.') {
        d[0][0] = 0
    } else {
        d[0][0] = 1
    }
    queue.add(Triple(0, 0, d[0][0]))
    while (queue.isNotEmpty()) {
        val e = queue.poll()
        //下
        if (e.first != H - 1) {
            val newD = e.third + if (S[e.first][e.second] == '.' && S[e.first + 1][e.second] == '#') 1 else 0
            if (d[e.first + 1][e.second] > newD) {
                d[e.first + 1][e.second] = newD
                queue.add(Triple(e.first + 1, e.second, newD))
            }
        }
        //右
        if (e.second != W - 1) {
            val newD = e.third + if (S[e.first][e.second] == '.' && S[e.first][e.second + 1] == '#') 1 else 0
            if (d[e.first][e.second + 1] > newD) {
                d[e.first][e.second + 1] = newD
                queue.add(Triple(e.first, e.second + 1, newD))
            }
        }
    }
    println(d[H - 1][W - 1])
}