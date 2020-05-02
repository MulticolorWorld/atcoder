package abc165

import kotlin.math.max

fun main() {
    val (n, m, q) = readLine()!!.split(" ").map { it.toInt() }
    val list = mutableListOf<Data>()
    for (i in 0 until q) {
        val tmp = readLine()!!.split(" ").map { it.toInt() }

        list.add(Data(tmp[0] - 1, tmp[1] - 1, tmp[2], tmp[3]))
    }

    val seq = mutableListOf<Int>()
    println(search(seq, list, m, n))
}

fun search(seq: List<Int>, data: List<Data>, maxNumber: Int, maxLength: Int): Int {
    if (seq.size == maxLength) {
        var ans = 0
        data.forEach { if (seq[it.b] - seq[it.a] == it.c) ans += it.d }
        return ans
    } else {
        var ans = 0
        val k = if (seq.isEmpty()) 1 else seq.last()
        for (i in k until maxNumber + 1) {
            ans = max(ans, search(seq.toMutableList().apply { add(i) }, data, maxNumber, maxLength))
        }
        return ans
    }
}

data class Data(
    val a: Int,
    val b: Int,
    val c: Int,
    val d: Int
)