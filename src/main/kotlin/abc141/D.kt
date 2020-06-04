package abc141

import java.util.*

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toLong() }

    val pQueue = PriorityQueue<Long>(N, compareByDescending { it })
    A.forEach { pQueue.add(it) }
    repeat(M) {
        val a = pQueue.poll()
        pQueue.add(a / 2)
    }
    println(pQueue.sum())
}