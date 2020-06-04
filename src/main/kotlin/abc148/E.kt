package abc148

fun main(args: Array<String>) {
    val N = readLine()!!.toLong()

    if (N % 2 == 1L) {
        println(0)
    } else {
        var x = 10L
        var ans = 0L
        while (x <= N) {
            ans += N / x
            x *= 5
        }
        println(ans)
    }
}