package abc61

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(" ").map { it.toLong() }
    val ab = Array(N.toInt()) { readLine()!!.split(" ").map { it.toInt() } }
    ab.sortBy { it[0] }
    var x = K
    var i = 0
    while (x > 0) {
        x -= ab[i][1]
        i++
    }
    println(ab[i - 1][0])
}