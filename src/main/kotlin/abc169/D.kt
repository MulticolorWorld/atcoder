package abc169

import kotlin.math.sqrt

fun main() {
    val N = readLine()!!.toLong()

    if (N == 1L) {
        println(0)
        return
    }

    var x = N
    val pSet = mutableSetOf<Long>()
    for (i in 2..sqrt(N.toDouble()).toInt()) {
        while (x % i == 0L) {
            pSet.add(i.toLong())
            x /= i
        }
    }
    if (x != 1L) {
        pSet.add(x)
    }

    if (pSet.isEmpty()) {
        println(1)
        return
    }

    var ans = 0
    x = N
    pSet.forEach { p ->
        var pp = p
        while (x % pp == 0L) {
            ans++
            x /= pp
            pp *= p
        }
    }
    println(ans)
}