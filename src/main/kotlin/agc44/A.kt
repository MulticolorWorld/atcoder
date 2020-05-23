package agc44

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val t = readLine()!!.toInt()
    val inputList = Array(t) { readLine()!!.split(" ").map(String::toLong) }
    inputList.forEach { input ->
        val (n, a, b, c, d) = input
        val memo = mutableMapOf<Long, Long>()
        val array = arrayOf(Pair(2L, a), Pair(3L, b), Pair(5L, c))

        fun search(now: Long): Long {
            if (now == 0L) {
                return 0
            } else if (now == 1L) {
                return d
            } else if (memo.containsKey(now)) {
                return memo[now]!!
            } else {
                var res = Long.MAX_VALUE
                if (now < res / d) res = now * d
                array.forEach {
                    val l = (now / it.first) * it.first
                    val r = ((now + it.first - 1L) / it.first) * it.first
                    res = min(res, d * abs(l - now) + it.second + search(l / it.first))
                    res = min(res, d * abs(r - now) + it.second + search(r / it.first))
                }
                memo[now] = res
                return res
            }
        }
        println(search(n))
    }
}