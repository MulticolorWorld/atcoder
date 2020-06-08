package abc112

import java.lang.Math.abs
import java.lang.Math.max

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val H = Array(N) { readLine()!!.split(" ").map { it.toLong() } }

    loop@ for (i in 0 until 101) {
        for (j in 0 until 101) {
            val hList = H.filter { it[2] != 0L }.map { it[2] + abs(i - it[0]) + abs(j - it[1]) }.distinct()
            if (hList.size == 1) {
                val h = hList[0]
                H.map { max(h - abs(i - it[0]) - abs(j - it[1]), 0) == it[2] }.all { it }.let {
                    if (it) {
                        println("$i $j $h")
                        return
                    }
                }
            }
        }
    }
}