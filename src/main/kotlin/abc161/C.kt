package abc161

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toLong() }

    val x = n - (n / k) * k
    if (n % k == 0L) {
        println(0)
    } else {
        if (k - x > n) {
            println(n)
        } else {
            println(k - x)
        }
    }
}
