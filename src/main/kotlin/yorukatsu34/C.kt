package yorukatsu34

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = mutableListOf<Pair<Long, Long>>()
    for (i in 0 until n) {
        readLine()!!.split(" ").map { it.toLong() }.let {
            a.add(Pair(it[0], it[1]))
        }
    }
    a.sortBy { it.second }

    var i = 0L
    a.forEach {
        i += it.first
        if (i > it.second) {
            println("No")
            return
        }
    }
    println("Yes")
}