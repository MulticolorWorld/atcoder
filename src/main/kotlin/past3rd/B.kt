package past3rd

fun main() {
    val (N, M, Q) = readLine()!!.split(" ").map { it.toInt() }
    val point = IntArray(M) { N }
    val solve = Array(N) { mutableSetOf<Int>() }
    repeat(Q) {
        val query = readLine()!!.split(" ").map { it.toInt() }
        if (query[0] == 1) {
            var sum = 0
            for (s in solve[query[1] - 1]) {
                sum += point[s]
            }
            println(sum)
        } else {
            solve[query[1] - 1].add(query[2] - 1)
            point[query[2] - 1]--
        }
    }
}