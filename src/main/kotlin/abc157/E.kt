package abc157

import java.util.*

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val S = readLine()!!
    val Q = readLine()!!.toInt()

    val s = S.toCharArray()

    val t = mutableMapOf<Char, TreeSet<Int>>()
    for (i in 0 until 26) {
        t['a' + i] = sortedSetOf()
    }
    for (i in s.indices) {
        t[s[i]]!!.add(i)
    }

    repeat(Q) {
        val q = readLine()!!.split(" ")
        if (q[0] == "1") {
            val i = q[1].toInt() - 1
            val c = q[2][0]
            t[s[i]]!!.remove(i)
            s[i] = c
            t[c]!!.add(i)
        } else {
            val l = q[1].toInt() - 1
            val r = q[2].toInt() - 1
            (0 until 26)
                .filter { i ->
                    val p = t['a' + i]!!.higher(l - 1) ?: N
                    p <= r
                }
                .count()
                .let { println(it) }
        }
    }
}

