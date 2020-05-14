package arc100

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }.toLongArray()
    for (i in 1..n) {
        a[i - 1] = a[i - 1] - i
    }
    a.sort()
    val median = a[(n + 1) / 2 - 1]
    var ans = 0L
    for (i in 0 until n) {
        ans += Math.abs(a[i] - median)
    }
    println(ans)
}