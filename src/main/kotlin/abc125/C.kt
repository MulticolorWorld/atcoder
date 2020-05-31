package abc125

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val gcdSegTree = IntSegTree(A, ::gcd, 0)
    var max = 0
    for (i in 0 until N) {
        val ori = gcdSegTree.get(i)
        gcdSegTree.update(i, 0)
        max = Math.max(max, gcdSegTree.getOp(0, N))
        gcdSegTree.update(i, ori)
    }
    println(max)
}

fun gcd(a: Int, b: Int): Int {
    if (a < b) return gcd(b, a)
    if (b == 0) return a
    return gcd(b, a % b)
}

class IntSegTree(
    original: IntArray,
    private val op: (Int, Int) -> Int,
    private val unit: Int
) {
    private var size = 1
    private var node = IntArray(0)

    init {
        while (size < original.size) {
            size *= 2
        }
        node = IntArray(2 * size - 1) { unit }
        for (i in original.indices) {
            node[i + size - 1] = original[i]
        }
        for (i in size - 2 downTo 0) {
            node[i] = op(node[2 * i + 1], node[2 * i + 2])
        }
    }

    fun update(index: Int, value: Int) {
        node[index + size - 1] = value
        var x = index + size - 1
        while (x > 0) {
            x = (x - 1) / 2
            node[x] = op(node[2 * x + 1], node[2 * x + 2])
        }
    }

    fun getOp(a: Int, b: Int, k: Int = 0, l: Int = 0, r: Int = size - 1): Int {
        if (r <= a || b <= l) {
            return unit
        }
        if (a <= l && r <= b) {
            return node[k]
        }
        val vl = getOp(a, b, 2 * k + 1, l, (l + r) / 2)
        val vr = getOp(a, b, 2 * k + 2, (l + r) / 2, r)
        return op(vl, vr)
    }

    fun get(index: Int): Int {
        return node[index + size - 1]
    }
}