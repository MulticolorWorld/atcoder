package yorukatsu21

fun main(array: Array<String>) {
    val x = readLine()!!.toInt()
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    println(x - a - (((x - a) / b) * b))
}