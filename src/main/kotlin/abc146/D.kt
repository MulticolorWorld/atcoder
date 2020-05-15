package abc146

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val g = Array(n + 1) { mutableListOf<Int>() }
    val ab = Array(n - 1) { readLine()!!.split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) } }
    val ans = mutableMapOf<Pair<Int, Int>, Int>()
    ab.forEach {
        g[it.first].add(it.second)
        g[it.second].add(it.first)
    }

    fun dfsWithPaint(e: Int, prevE: Int, prevColor: Int) {
        var i = 1
        ans.put(Pair(e, prevE), prevColor)
        ans.put(Pair(prevE, e), prevColor)
        g[e].forEach {
            if (it != prevE) {
                if (i == prevColor) i++
                dfsWithPaint(it, e, i)
                i++
            }
        }
    }
    dfsWithPaint(1, 0, 0)
    ab.map { ans.get(it)!! }.let {
        println(it.max()!!)
        it.forEach { println(it) }
    }
}