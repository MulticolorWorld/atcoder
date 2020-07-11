package aising2020

fun main() {
    val N = readLine()!!.toInt()
    val ans = IntArray(N + 1)
    for (x in 1L..100L) {
        for (y in 1L..100L) {
            for (z in 1L..100L) {
                val p = x * x + y * y + z * z + x * y + y * z + z * x
                if (p <= N) {
                    ans[p.toInt()]++
                }
            }
        }
    }
    ans.slice(1..N).joinToString(separator = "\n").let { println(it) }
}