package abc163

import kotlin.math.pow

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    val array = List(n + 1) { i -> i.toLong() }
    val sumList = mutableListOf<Long>()
    sumList.add(array[0])
    for (i in 1..n) {
        sumList.add(sumList[i - 1] + array[i])
    }
    val arrayR = array.asReversed()
    val sumListR = mutableListOf<Long>()
    sumListR.add(arrayR[0])
    for (i in 1..n) {
        sumListR.add(sumListR[i - 1] + arrayR[i])
    }

    var ans = 1L
    for (i in k until n + 1) {
        val min = sumList[i - 1]
        val max = sumListR[i - 1]
        ans += (max - min + 1) % (10.toDouble().pow(9).toLong() + 7)
    }
    println(ans % (10.toDouble().pow(9).toLong() + 7))
}