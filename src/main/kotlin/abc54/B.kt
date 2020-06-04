package abc54

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val A = Array(N) { readLine()!! }
    val B = Array(M) { readLine()!! }

    for (i in 0 until N - M + 1) {
        for (j in 0 until N - M + 1) {
            var f = true
            for (x in 0 until M) {
                for (y in 0 until M) {
                    f = f && A[i + x][j + y] == B[x][y]
                }
            }
            if (f) {
                println("Yes")
                return
            }
        }
    }
    println("No")
}