package testContest202004

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = mutableListOf<Pair<Int, String>>()
    for (i in 0 until n) {
        val (x, c) = readLine()!!.split(" ")
        list.add(Pair(x.toInt(), c))
    }
    val rList = list.filter { it.second == "R" }.sortedBy { it.first }
    val bList = list.filter { it.second == "B" }.sortedBy { it.first }

    rList.forEach { println(it.first) }
    bList.forEach { println(it.first) }
}