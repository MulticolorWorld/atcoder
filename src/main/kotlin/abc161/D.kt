package abc161

import java.util.*

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    val q: Queue<Long> = LinkedList<Long>(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))

    for (i in 1 until k) {
        val x = q.remove()
        if (x % 10 != 0L) q.add(10 * x + (x % 10) - 1)
        q.add(10 * x + (x % 10))
        if (x % 10 != 9L) q.add(10 * x + (x % 10) + 1)
    }
    println(q.remove())
}