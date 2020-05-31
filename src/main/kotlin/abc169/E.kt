package abc169

fun main() {
    val N = readLine()!!.toInt()
    val AB = Array(N) { readLine()!!.split(" ").map { it.toLong() }.let { Pair(it[0], it[1]) } }

    if (N % 2 == 1) {
        val aMedian = AB.map { it.first }.sorted()[(N + 1) / 2 - 1]
        val bMedian = AB.map { it.second }.sorted()[(N + 1) / 2 - 1]
        println(bMedian - aMedian + 1)
    } else {
        val aMedian = AB.map { it.first * 2 }.sorted().let { (it[N / 2 - 1] + it[N / 2]) / 2 }
        val bMedian = AB.map { it.second * 2 }.sorted().let { (it[N / 2 - 1] + it[N / 2]) / 2 }
        println(bMedian - aMedian + 1)
    }
}