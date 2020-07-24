package abc173


fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }.sorted().reversed()

    var n = N
    n--
    var i = 1
    var ans = 0L
    while (n != 0) {
        ans += A[i / 2]
        n--
        i++
    }
    println(ans)
}