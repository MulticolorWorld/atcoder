package abc161

fun main(args: Array<String>) {
    val (x, y, z) = readLine()!!.split(" ").map { it.toInt() }
    println("$z $x $y")
}