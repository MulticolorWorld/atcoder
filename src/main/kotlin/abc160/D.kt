package abc160

fun main(args: Array<String>) {
    val (n, x, y) = readLine()!!.split(" ").map { it.toInt() }
    val k = Array(n) { 0 }
    for (i in 1 until n) {
        for (j in i + 1 until n + 1) {
            if (j - i > abs(x - i) + abs(y - j) + 1) {
                k[abs(x - i) + abs(y - j) + 1]++
            } else {
                k[j - i]++
            }
        }
    }
    for (i in 1 until n) {
        println(k[i])
    }
}

fun abs(a: Int): Int {
    return if (a > 0) a else -a
}