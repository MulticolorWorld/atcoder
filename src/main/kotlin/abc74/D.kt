package abc74

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = Array(N) { readLine()!!.split(" ").map { it.toLong() }.toLongArray() }
    val redundant = Array(N) { BooleanArray(N) }

    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (A[i][j] > A[i][k] + A[k][j]) {
                    println(-1)
                    return
                }
                if (A[i][j] == A[i][k] + A[k][j] && A[i][k] > 0 && A[k][j] > 0) {
                    redundant[i][j] = true
                }
            }
        }
    }

    var ans = 0L
    for (i in 0 until N) {
        for (j in i + 1 until N) {
            if (!redundant[i][j]) ans += A[i][j]
        }
    }
    println(ans)
}

