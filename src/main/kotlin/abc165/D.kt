package abc165

import kotlin.math.floor
import kotlin.math.min

fun main() {
    val (a, b, n) = readLine()!!.split(" ").map { it.toLong() }

    println(
        floor(a.toDouble() * min(b - 1, n) / b.toDouble()).toLong()
    )
}