package educationalDP

import java.lang.Math.max

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val outEdge = Array(n + 1) { mutableListOf<Int>() }
    val inEdge = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        readLine()!!.split(" ").map { it.toInt() }.let {
            outEdge[it[0]].add(it[1])
            inEdge[it[1]].add(it[0])
        }
    }

    val visited = BooleanArray(n + 1) { false }
    val order = mutableListOf<Int>()
    for (i in 1..n) {
        if (!visited[i]) dfs(i, outEdge, visited, order)
    }
    order.reverse()

    val dp = IntArray(n + 1)
    for (i in order) {
        var max = 0
        for (v in inEdge[i]) {
            max = max(max, dp[v] + 1)
        }
        dp[i] = max
    }
    println(dp.max())
}

fun dfs(v: Int, outEdge: Array<MutableList<Int>>, visited: BooleanArray, order: MutableList<Int>) {
    visited[v] = true
    for (e in outEdge[v]) {
        if (!visited[e]) dfs(e, outEdge, visited, order)
    }
    order.add(v)
}