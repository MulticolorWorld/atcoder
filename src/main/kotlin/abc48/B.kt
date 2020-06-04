package abc48

fun main(args: Array<String>) {
    val (A, B, X) = readLine()!!.split(" ").map { it.toLong() }

    println(B / X - A / X + if (A % X == 0L) 1 else 0)
}