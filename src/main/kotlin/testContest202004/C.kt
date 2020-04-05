package testContest202004

fun main(args: Array<String>) {
    val (a1, a2, a3) = readLine()!!.split(" ").map { it.toInt() }
    when {
        a1 == 1 && a2 == 1 && a3 == 1 -> println(1)
        a1 == 2 && a2 == 1 && a3 == 1 -> println(3)
        a1 == 2 && a2 == 2 && a3 == 1 -> println(5)
        a1 == 2 && a2 == 2 && a3 == 2 -> println(5)
        a1 == 3 && a2 == 1 && a3 == 1 -> println(6)
        a1 == 3 && a2 == 2 && a3 == 1 -> println(16)
        a1 == 3 && a2 == 2 && a3 == 2 -> println(21)
        a1 == 3 && a2 == 3 && a3 == 1 -> println(21)
        a1 == 3 && a2 == 3 && a3 == 2 -> println(42)
        a1 == 3 && a2 == 3 && a3 == 3 -> println(42)
    }
}