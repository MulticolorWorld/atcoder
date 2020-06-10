package agc8

import java.lang.Math.abs

fun main(args: Array<String>) {
    val (X, Y) = readLine()!!.split(" ").map { it.toLong() }
    if (Y == 0L) {
        println(abs(X) + if (X > 0) 1 else 0)
    } else if (X >= 0 && Y > 0) {
        if (Y >= X) {
            println(Y - X)
        } else {
            println(X - Y + 2)
        }
    } else if (X >= 0 && Y < 0) {
        if (-X <= Y) {
            println(X - abs(Y) + 1)
        } else {
            println(abs(Y) - X + 1)
        }
    } else if (X < 0 && Y > 0) {
        if (X <= -Y) {
            println(abs(X) - Y + 1)
        } else {
            println(Y - abs(X) + 1)
        }
    } else {
        if (Y >= X) {
            println(Y - X)
        } else {
            println(X - Y + 2)
        }
    }
}