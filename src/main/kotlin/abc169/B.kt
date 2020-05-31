package abc169

import java.math.BigDecimal

fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { BigDecimal(it) }

    if (A.contains(BigDecimal.ZERO)) {
        println(0)
        return
    }

    var ans = BigDecimal.ONE
    for (i in A.indices) {
        ans *= A[i]
        if (ans > BigDecimal(10).pow(18)) {
            println(-1)
            return
        }
    }
    println(ans.toPlainString())
}