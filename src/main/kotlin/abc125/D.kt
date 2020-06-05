package abc125

import java.lang.Math.abs
import java.lang.Math.min

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }
    val minus = A.filter { it < 0 }
    val plus = A.filter { it >= 0 }
    if (minus.size % 2 == 0) {
        println(A.map { abs(it) }.sum())
    } else {
        println(A.map { abs(it) }.sum() - 2 * min(abs(minus.max()!!), plus.min() ?: Long.MAX_VALUE))
    }
}