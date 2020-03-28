package abc160

fun main(args: Array<String>) {
    val x = readLine()!!.toInt()
    val a = x / 500
    val x1 = x - a * 500
    val b = x1 / 5
    println(a * 1000 + b * 5)
}