package abc166

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val h = readLine()!!.split(" ").map { it.toInt() }
    val e = Array(n) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        e[a - 1].add(b - 1)
        e[b - 1].add(a - 1)
    }

    var count = 0
    for (i in 0 until n) {
        var f = true
        e[i].forEach {
            if (h[i] <= h[it]) f = false
        }
        if (f) count++
    }
    println(count)
}

