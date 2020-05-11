package abc73

fun main(args: Array<String>) {
    val (n, m, rr) = readLine()!!.split(" ").map { it.toInt() }
    val r = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val g = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE / 10 } }
    repeat(m) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        g[a][b] = c
        g[b][a] = c
    }
    for (i in 1..n) {
        g[i][i] = 0
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j])
            }
        }
    }

    val list = mutableListOf<IntArray>()
    permutation(r, IntArray(0), list)

    var min = Int.MAX_VALUE / 10
    list.forEach {
        var ans = 0
        for (i in 1 until it.size) {
            ans += g[it[i - 1]][it[i]]
        }
        min = Math.min(min, ans)
    }

    println(min)
}

fun permutation(r1: IntArray, r2: IntArray, list: MutableList<IntArray>) {
    if (r1.size <= 1) {
        list.add(r2 + r1)
    } else {
        for (i in r1.indices) {
            permutation(r1.sliceArray(0 until i) + r1.sliceArray(i + 1 until r1.size), r2 + r1[i], list)
        }
    }
}