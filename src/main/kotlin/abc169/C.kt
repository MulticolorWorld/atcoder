package abc169

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val (A, B) = readLine()!!.split(" ").map { BigDecimal(it) }
    println(A.multiply(B).setScale(0, RoundingMode.DOWN).toPlainString())
}