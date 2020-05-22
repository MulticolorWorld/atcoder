package abc126

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val zyx = Array(m) { readLine()!!.split(" ").map { it.toInt() }.let { Triple(it[0], it[1], it[2]) } }

    val tree = UnionFind(n)
    zyx.forEach {
        tree.unite(it.first - 1, it.second - 1)
    }
    println(tree.size())
}

class UnionFind(n: Int) {

    private val parent = IntArray(n) { i -> i }

    fun root(x: Int): Int {
        if (parent[x] == x) {
            return x
        } else {
            parent[x] = root(parent[x])
            return parent[x]
        }
    }

    fun unite(x: Int, y: Int) {
        val rx = root(x)
        val ry = root(y)
        if (rx != ry) {
            parent[rx] = ry
        }
    }

    fun size(): Int {
        return (parent.indices).map { root(it) }.distinct().size
    }
}