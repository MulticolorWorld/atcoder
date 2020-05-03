package abc166

import kotlin.math.pow

fun main() {
    val x = readLine()!!.toLong()
    for (a in -120 until 121) {
        for (b in -120 until 121) {
            if (a.toDouble().pow(5).toLong() - b.toDouble().pow(5).toLong() == x) {
                println("$a $b")
                return
            }
        }
    }
}