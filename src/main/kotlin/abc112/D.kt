package abc112

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toLong() }
    val list = mutableListOf<Long>()
    for (i in 1..Math.sqrt(m.toDouble()).toInt()) {
        if (m % i == 0L) {
            list.add(i.toLong())
            list.add(m / i)
        }
    }
    list.sortDescending()
    list.forEach {
        if ((m - it * (n - 1)) % it == 0L && m - it * (n - 1) > 0) {
            println(it)
            return
        }
    }
}