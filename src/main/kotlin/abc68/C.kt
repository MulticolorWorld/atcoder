package abc68

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val ab = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        ab[a].add(b)
        ab[b].add(a)
    }
    fun dfs(d: Int, v: Int): Boolean {
        return if (d == 2) {
            v == n
        } else {
            ab[v].map {
                dfs(d + 1, it)
            }.contains(true)
        }
    }
    dfs(0, 1).let { if (it) println("POSSIBLE") else println("IMPOSSIBLE") }
}