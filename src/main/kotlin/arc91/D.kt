package arc91

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(" ").map { it.toLong() }
    if (K == 0L) {
        println(N * N)
        return
    }
    var ans = 0L
    for (b in 1..N) {
        val div = N / b
        val rem = N % b
        ans += div * (Math.max(0, b - K))
        ans += Math.max(0, rem - K + 1)
    }
    println(ans)
}