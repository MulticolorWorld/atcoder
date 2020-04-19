package abc163

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }

    val bukaArray = Array(n) { 0 }
    for (i in 0 until n - 1) {
        bukaArray[a[i]]++
    }
    bukaArray.drop(1).forEach { println(it) }
    println(0)
}