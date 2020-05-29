package abc72

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val P = readLine()!!.split(" ").map { it.toInt() }.map { it - 1 }.toIntArray()

    var count = 0
    for (i in 0 until N - 1) {
        if (P[i] == i) {
            P.swap(i, i + 1)
            count++
        }
    }
    if (P[N - 1] == N - 1) {
        P.swap(N - 2, N - 1)
        count++
    }
    println(count)
}

fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}