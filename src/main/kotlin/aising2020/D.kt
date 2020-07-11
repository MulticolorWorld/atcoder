package aising2020

fun main() {
    val N = readLine()!!.toInt()
    val X = readLine()!!
    val nMax = 2 * 100000
    val table = IntArray(nMax + 1)
    for (i in 1..nMax) {
        table[i] = table[i % popCount(i)] + 1
    }

    val bitCount = X.filter { c -> c == '1' }.count()
    val plus = bitCount + 1
    val minus = bitCount - 1
    val twoRemPlus = LongArray(N).apply { this[0] = (1L % plus) }
    val twoRemMinus = LongArray(N).apply { if (1 <= minus) this[0] = (1L % minus) else this[0] = 0 }
    for (i in 1 until N) {
        twoRemPlus[i] = (twoRemPlus[i - 1] * 2) % plus
        twoRemMinus[i] = if (1 <= minus) (twoRemMinus[i - 1] * 2) % minus else 0
    }
    var remPlus = 0L
    var remMinus = 0L
    for (i in 0 until N) {
        if (X[N - 1 - i] == '1') {
            remPlus = (remPlus + twoRemPlus[i]) % plus
            remMinus = if (1 <= minus) (remMinus + twoRemMinus[i]) % minus else 0
        }
    }

    val ans = LongArray(N)
    for (i in 0 until N) {
        if (X[N - 1 - i] == '1') {
            ans[i] = (remMinus - twoRemMinus[i]).let {
                if (minus == 0) {
                    -1
                } else {
                    (it % minus).let {
                        if (it < 0) it + minus else it
                    }
                }
            }
        } else {
            ans[i] = (remPlus + twoRemPlus[i]).let { it % plus }
        }
    }
    println(ans.map { if (it.toInt() == -1) 0 else (table[it.toInt()] + 1) }.reversed().joinToString(separator = "\n"))
}

fun popCount(n: Int): Int {
    var tmp = n
    var ans = 0
    while (tmp != 0) {
        if (tmp % 2 == 1) ans++
        tmp /= 2
    }
    return ans
}
