package past3rd

fun main() {
    val N = readLine()!!.toInt()
    val Q = readLine()!!.toInt()
    val row = IntArray(N + 1) { i -> i }
    val col = IntArray(N + 1) { i -> i }
    var swap = 0

    repeat(Q) {
        val query = readLine()!!.split(" ").map { it.toInt() }
        when (query[0]) {
            1 -> {
                if (swap % 2 == 0) {
                    row.swap(query[1], query[2])
                } else {
                    col.swap(query[1], query[2])
                }
            }
            2 -> {
                if (swap % 2 == 0) {
                    col.swap(query[1], query[2])
                } else {
                    row.swap(query[1], query[2])
                }
            }
            3 -> {
                swap++
            }
            4 -> {
                if (swap % 2 == 0) {
                    println(N.toLong() * (row[query[1]] - 1) + col[query[2]] - 1)
                } else {
                    println(N.toLong() * (row[query[2]] - 1) + col[query[1]] - 1)
                }
            }
        }
    }
}

fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}