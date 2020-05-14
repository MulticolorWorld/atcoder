package abc87

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val g = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (l, r, d) = readLine()!!.split(" ").map { it.toInt() }
        g[l].add(Pair(r, d))
        g[r].add(Pair(l, -d))
    }
    val visited = BooleanArray(n + 1) { false }
    val x = IntArray(n + 1)

    fun dfs(now: Int): Boolean {
        visited[now] = true
        var f = true
        g[now].forEach {
            if (visited[it.first] && x[it.first] - x[now] != it.second) {
                f = false
            }
            if (!visited[it.first]) {
                x[it.first] = x[now] + it.second
                f = f && dfs(it.first)
            }
        }
        return f
    }

    var f = true
    for (i in 1..n) {
        if (!visited[i]) {
            f = f && dfs(i)
        }
    }
    if (f) println("Yes") else println("No")
}