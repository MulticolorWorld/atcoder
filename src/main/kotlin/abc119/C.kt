package abc119

fun main(args: Array<String>) {
    val (N, A, B, C) = readLine()!!.split(" ").map { it.toInt() }
    val l = IntArray(N) { readLine()!!.toInt() }

    fun dfs(count: Int, a: Int, b: Int, c: Int): Int {
        if (count == N) {
            if (a != 0 && b != 0 && c != 0) {
                return Math.abs(A - a) + Math.abs(B - b) + Math.abs(C - c) - 30
            } else {
                return Int.MAX_VALUE / 10
            }
        }
        var min = Int.MAX_VALUE / 10
        min = Math.min(min, dfs(count + 1, a, b, c))
        min = Math.min(min, dfs(count + 1, a + l[count], b, c) + 10)
        min = Math.min(min, dfs(count + 1, a, b + l[count], c) + 10)
        min = Math.min(min, dfs(count + 1, a, b, c + l[count]) + 10)
        return min
    }
    println(dfs(0, 0, 0, 0))
}