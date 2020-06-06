package past3rd

import java.math.BigDecimal

fun main() {
    val (A, R, N) = readLine()!!.split(" ").map { it.toInt() }
    try {
        val an = BigDecimal(A) * BigDecimal(R).pow(N - 1)
        if (an > BigDecimal(10).pow(9)) {
            println("large")
        } else {
            println(an.toPlainString())
        }
    } catch (e: ArithmeticException) {
        println("large")
    }
}