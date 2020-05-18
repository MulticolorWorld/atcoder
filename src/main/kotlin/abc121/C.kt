package abc121

fun main(args: Array<String>) {
    var (n, m) = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val ab = Array(n) { readLine()!!.split(" ").map { it.toLong() }.let { Pair(it[0], it[1]) } }
    ab.sortBy { it.first }
    var money = 0L
    for (i in 0 until n) {
        if (m >= ab[i].second) {
            money += ab[i].first * ab[i].second
            m -= ab[i].second.toInt()
        } else {
            money += ab[i].first * m
            break
        }
    }
    println(money)
}