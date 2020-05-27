package abc151

fun main(args: Array<String>) {
    val (H, W) = readLine()!!.split(" ").map { it.toInt() }
    val S = Array(H) { readLine()!! }

    val g = Array(H * W) { IntArray(H * W) { Int.MAX_VALUE / 10 } }
    for (i in 0 until H) {
        for (j in 0 until W) {
            if (S[i][j] == '.') {
                g[W * i + j][W * i + j] = 1
                if (j != W - 1 && S[i][j + 1] == '.') {
                    g[W * i + j][W * i + j + 1] = 1
                    g[W * i + j + 1][W * i + j] = 1
                }
                if (i != H - 1 && S[i + 1][j] == '.') {
                    g[W * i + j][W * i + j + W] = 1
                    g[W * i + j + W][W * i + j] = 1
                }
            }
        }
    }

    for (k in 0 until H * W) {
        for (i in 0 until H * W) {
            for (j in 0 until H * W) {
                g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j])
            }
        }
    }

    var max = 0
    for (i in 0 until H * W)
        for (j in 0 until H * W) {
            if (g[i][j] != Int.MAX_VALUE / 10) max = Math.max(max, g[i][j])
        }
    println(max)
}