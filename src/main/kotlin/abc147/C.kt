package abc147

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf() }
    for (i in 1..n) {
        repeat(readLine()!!.toInt()) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            a[i].add(Pair(x, y))
        }
    }

    fun search(s: String): Int {
        if (s.length == n + 1) {
            var f = true
            for (i in 1..n) {
                if (s[i] == '1') {
                    f = f && a[i].map { s[it.first].toString() == it.second.toString() }.all { it }
                }
            }
            return if (f) s.filter { it == '1' }.length else 0
        } else {
            return Math.max(search(s + "0"), search(s + "1"))
        }
    }

    println(search("0"))
}