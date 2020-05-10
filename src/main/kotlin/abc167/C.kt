package abc167

fun main() {
    val (n, m, x) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(n) { IntArray(m + 1) }
    for (i in 0 until n) {
        readLine()!!.split(" ").map { it.toInt() }.let {
            a[i] = it.toIntArray()
        }
    }

    var min = Int.MAX_VALUE / 10
    for (i in 0..(1 shl n)) {
        val b = IntArray(m + 1)
        for (j in 0 until n) {
            if (i.shr(j).and(1) == 1) {
                for (k in 0..m) {
                    b[k] += a[j][k]
                }
            }
        }
        if ((1..m).map { b[it] >= x }.all { it }) {
            min = Math.min(min, b[0])
        }
    }
    if (min == Int.MAX_VALUE / 10) println(-1) else println(min)
}