package agc2

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val num = IntArray(N + 1) { 1 }
    val isRed = BooleanArray(N + 1) { false }
    isRed[1] = true
    repeat(M) {
        val (X, Y) = readLine()!!.split(" ").map { it.toInt() }
        num[X]--
        num[Y]++
        if (isRed[X]) {
            isRed[Y] = true
        }
        if (num[X] == 0) {
            isRed[X] = false
        }
    }
    println(isRed.filter { it }.count())
}