package abc158

import java.util.*

fun main(args: Array<String>) {
    var s = readLine()!!
    val q = readLine()!!.toInt()
    var reversed = false
    val deque = ArrayDeque<String>()
    s.toCharArray().map { it.toString() }.forEach { deque.addLast(it) }
    repeat(q) {
        val query = readLine()!!.split(" ")
        if (query.size == 1) {
            reversed = !reversed
        } else {
            if (!reversed && query[1] == "1" || reversed && query[1] == "2") {
                deque.addFirst(query[2])
            } else {
                deque.addLast(query[2])
            }
        }
    }
    if (reversed) {
        println(deque.reversed().joinToString(separator = ""))
    } else {
        println(deque.joinToString(separator = ""))
    }
}