package lib

fun main() {
    val g = Array(10) { IntArray(10) }
    for (k in 0 until 10) {
        for (i in 0 until 10) {
            for (j in 0 until 10) {
                g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j])
            }
        }
    }
}