package agc11

fun main(args: Array<String>) {
    val (N, C, K) = readLine()!!.split(" ").map { it.toLong() }
    val T = LongArray(N.toInt()) { readLine()!!.toLong() }.sorted().toLongArray()

    var busCount = 0L
    var first = -1L
    var count = 0L
    for (i in T.indices) {
        if (first == -1L) {
            count++
            first = T[i]
        } else {
            if (first + K >= T[i] && count < C) {
                count++
            } else {
                busCount++
                first = T[i]
                count = 1L
            }
        }
    }
    println(busCount + 1)
}