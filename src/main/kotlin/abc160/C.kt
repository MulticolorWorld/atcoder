package abc160

fun main(args: Array<String>) {
    val (k, n) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    var l = a[0] + k - a[n - 1]
    for (i in 1 until n) {
        if (l < a[i] - a[i - 1]) {
            l = a[i] - a[i - 1]
        }
    }
    println(k - l)
}