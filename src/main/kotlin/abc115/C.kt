package abc115

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val h = IntArray(n) { readLine()!!.toInt() }.sorted()
    var min = Int.MAX_VALUE
    for (i in 0 until n - k + 1) {
        min = Math.min(min, h[i + k - 1] - h[i])
    }
    println(min)
}