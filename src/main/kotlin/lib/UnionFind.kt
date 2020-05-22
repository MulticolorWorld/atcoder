package lib

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