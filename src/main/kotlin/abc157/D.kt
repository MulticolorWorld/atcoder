package abc157

fun main(args: Array<String>) {
    val (N, M, K) = readLine()!!.split(" ").map { it.toInt() }
    val uf = UnionFind(N)
    val friend = IntArray(N + 1)

    repeat(M) {
        val (A, B) = readLine()!!.split(" ").map { it.toInt() }
        uf.unite(A, B)
        friend[A]++
        friend[B]++
    }

    val size = IntArray(N + 1)
    for (i in size.indices) {
        size[i] = uf.unionSize(i) - friend[i] - 1
    }

    repeat(K) {
        val (C, D) = readLine()!!.split(" ").map { it.toInt() }
        if (uf.isSameUnion(C, D)) {
            size[C]--
            size[D]--
        }
    }

    println(size.drop(1).joinToString(separator = " "))
}

class UnionFind(n: Int) {

    private val parent = IntArray(n + 1) { i -> i }
    private val size = IntArray(n + 1) { i -> 1 }

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
            size[ry] += size[rx]
        }
    }

    fun isSameUnion(x: Int, y: Int): Boolean {
        return root(x) == root(y)
    }

    fun unionSize(x: Int): Int {
        return size[root(x)]
    }
}