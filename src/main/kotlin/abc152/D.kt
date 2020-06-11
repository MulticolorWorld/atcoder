package abc152

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()

    val c = Array(10) { IntArray(10) }
    for (i in 1..N) {
        c[i.toString().first().toString().toInt()][i.toString().last().toString().toInt()]++
    }

    var ans = 0L
    for (i in 0 until 10) {
        for (j in 0 until 10) {
            ans += c[i][j] * c[j][i]
        }
    }
    println(ans)
}