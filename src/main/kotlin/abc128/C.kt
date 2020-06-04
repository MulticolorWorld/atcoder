package abc128

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    val S = Array(M) { readLine()!!.split(" ").map { it.toInt() }.drop(1) }
    val P = readLine()!!.split(" ").map { it.toInt() }

    var ans = 0
    fun bitSearch(bit: String) {
        if (bit.length == N + 1) {
            S.indices.map { i ->
                S[i].map { bit[it] }.count { it == '1' }.let { it % 2 == P[i] }
            }.all { it }.let { if (it) ans++ }
        } else {
            bitSearch(bit + "0")
            bitSearch(bit + "1")
        }
    }
    bitSearch("0")
    println(ans)
}