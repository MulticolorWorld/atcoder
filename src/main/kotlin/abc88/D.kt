package abc88

import java.util.*

fun main(args: Array<String>) {
    val (H, W) = readLine()!!.split(" ").map { it.toInt() }
    val S = Array(H) { readLine()!! }

    val d = Array(H) { IntArray(W) { Int.MAX_VALUE / 10 } }
    val queue = PriorityQueue<Triple<Int, Int, Int>>(H * W, compareBy { it.third })
    d[0][0] = 1
    queue.add(Triple(0, 0, 1))
    while (queue.isNotEmpty()) {
        val e = queue.poll()
        //上
        if (e.first != 0 && S[e.first - 1][e.second] == '.' && d[e.first - 1][e.second] > e.third + 1) {
            d[e.first - 1][e.second] = e.third + 1
            queue.add(Triple(e.first - 1, e.second, e.third + 1))
        }
        //下
        if (e.first != H - 1 && S[e.first + 1][e.second] == '.' && d[e.first + 1][e.second] > e.third + 1) {
            d[e.first + 1][e.second] = e.third + 1
            queue.add(Triple(e.first + 1, e.second, e.third + 1))
        }
        //左
        if (e.second != 0 && S[e.first][e.second - 1] == '.' && d[e.first][e.second - 1] > e.third + 1) {
            d[e.first][e.second - 1] = e.third + 1
            queue.add(Triple(e.first, e.second - 1, e.third + 1))
        }
        //右
        if (e.second != W - 1 && S[e.first][e.second + 1] == '.' && d[e.first][e.second + 1] > e.third + 1) {
            d[e.first][e.second + 1] = e.third + 1
            queue.add(Triple(e.first, e.second + 1, e.third + 1))
        }
    }

    val white = S.map { s -> s.filter { c -> c == '.' }.length }.sum()
    println(if (d[H - 1][W - 1] == Int.MAX_VALUE / 10) -1 else white - d[H - 1][W - 1])
}