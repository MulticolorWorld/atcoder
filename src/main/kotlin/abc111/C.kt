package abc111

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val v = readLine()!!.split(" ").map { it.toInt() }
    if (v.all { it == v[0] }) {
        println(n / 2)
        return
    }

    val aOdd = mutableMapOf(Pair(0, 0))
    val aEven = mutableMapOf(Pair(0, 0))
    for (i in 1..n) {
        val a = v[i - 1]
        if (i % 2 == 0) {
            if (aEven.containsKey(a)) {
                aEven[a] = aEven[a]!! + 1
            } else {
                aEven[a] = 1
            }
        }
        if (i % 2 == 1) {
            if (aOdd.containsKey(a)) {
                aOdd[a] = aOdd[a]!! + 1
            } else {
                aOdd[a] = 1
            }
        }
    }

    val maxEven = aEven.toList().sortedBy { it.second }.let { it[it.size - 1] }
    val nextMaxEven = aEven.toList().sortedBy { it.second }.let { it[it.size - 2] }
    val maxOdd = aOdd.toList().sortedBy { it.second }.let { it[it.size - 1] }
    val nextMaxOdd = aOdd.toList().sortedBy { it.second }.let { it[it.size - 2] }
    if (maxEven.first != maxOdd.first) {
        println(n - maxEven.second - maxOdd.second)
    } else {
        println(Math.min(n - maxEven.second - nextMaxOdd.second, n - nextMaxEven.second - maxOdd.second))
    }
}