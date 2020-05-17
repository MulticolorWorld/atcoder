package abc168

import kotlin.math.*

fun main() {
    val (A, B, H, M) = readLine()!!.split(" ").map { it.toDouble() }

    val hRad = (H * 2.0 * PI) / 12.0 + (2 * PI * M) / (12 * 60)
    val mRad = (M * 2.0 * PI) / 60.0
    println(sqrt(A.pow(2.0) + B.pow(2.0) - 2.0 * A * B * cos(abs(mRad - hRad))))
}