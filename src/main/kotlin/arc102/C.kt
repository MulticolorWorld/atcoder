package arc102

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    var divisible = 0L
    var remainderHalf = 0L
    for (i in 1..N) {
        if (i % K == 0) {
            divisible++
        }
        if (i % K == K / 2) {
            remainderHalf++
        }
    }
    if (K % 2 == 1) {
        println(divisible * divisible * divisible)
    } else {
        println(divisible * divisible * divisible + remainderHalf * remainderHalf * remainderHalf)
    }
}