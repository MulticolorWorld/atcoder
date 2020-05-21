package abc144

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()

    val list = mutableListOf<Long>()
    for (i in 1..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0L) {
            list.add(i.toLong())
            list.add(n / i)
        }
    }
    var min = Long.MAX_VALUE / 10
    list.forEach {
        val a = it
        val b = n / it
        min = Math.min(min, a + b - 2)
    }
    println(min)
}