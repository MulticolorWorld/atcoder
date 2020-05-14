package abc128

fun main(args: Array<String>) {
    val (a, p) = readLine()!!.split(" ").map { it.toInt() }
    println((a * 3 + p) / 2)
}