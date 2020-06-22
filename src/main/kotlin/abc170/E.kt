package abc170

import java.util.*
import kotlin.math.min

fun main() {
    val (N, Q) = readLine()!!.split(" ").map { it.toInt() }

    //所属とレーティング
    val belongs = IntArray(N + 1)
    val rating = IntArray(N + 1)
    //その園のレーティング情報
    val ratingInKinder = Array(2 * 100000 + 1) { TreeMap<Int, Int>() }
    for (i in 1..N) {
        val (A, B) = readLine()!!.split(" ").map { it.toInt() }
        rating[i] = A
        belongs[i] = B
        ratingInKinder[B][A] = (ratingInKinder[B][A] ?: 0) + 1
    }

    //平等さ算出のためのセグメントツリー
    val st = IntSegTree(
        ratingInKinder.map { if (it.isEmpty()) Int.MAX_VALUE else it.lastKey() }.toIntArray(),
        { i1, i2 -> min(i1, i2) },
        Int.MAX_VALUE
    )

    val q = Array(Q) { Pair(0, 0) }
    val ans = IntArray(Q)
    for (i in 0 until Q) {
        q[i] = readLine()!!.split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) }
    }

    q.forEachIndexed { i, pair ->
        val child = pair.first
        val before = belongs[child]
        val after = pair.second

        //前の所属先に関する処理
        if (ratingInKinder[before][rating[child]]!! == 1) {
            ratingInKinder[before].remove(rating[child])
        } else {
            ratingInKinder[before][rating[child]] = ratingInKinder[before][rating[child]]!! - 1
        }
        if (ratingInKinder[before].isEmpty()) {
            st.update(before, Int.MAX_VALUE)
        } else {
            st.update(before, ratingInKinder[before].lastKey())
        }

        //次の所属先に関する処理
        if (!ratingInKinder[after].containsKey(rating[child])) {
            ratingInKinder[after].put(rating[child], 1)
        } else {
            ratingInKinder[after][rating[child]] = ratingInKinder[after][rating[child]]!! + 1
        }
        st.update(after, ratingInKinder[after].lastKey())

        belongs[child] = after
        ans[i] = st.getOp(1, ratingInKinder.size)
    }

    println(ans.joinToString(separator = "\n"))
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

    fun getOp(a: Int, b: Int, k: Int = 0, l: Int = 0, r: Int = size): Int {
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