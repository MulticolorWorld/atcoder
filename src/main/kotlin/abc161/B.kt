package abc161

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }

    val a1 = a.filter { it >= a.sum().div((4 * m).toDouble()) }
    if (a1.size < m) {
        println("No")
    } else {
        println("Yes")
    }
}