package abc130

fun main(args: Array<String>) {
    val (w, h, x, y) = readLine()!!.split(" ").map { it.toLong() }
    println("${w * h / 2.0} ${if (x * 2 == w && y * 2 == h) 1 else 0}")
}