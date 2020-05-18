package abc70

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val t = LongArray(n) { readLine()!!.toLong() }
    var ans = t[0]
    for (i in 1 until n) {
        ans = lcm(t[i], ans)
    }
    println(ans)
}

fun lcm(a: Long, b: Long): Long {
    return (a / gcd(a, b)) * b
}

fun gcd(a: Long, b: Long): Long {
    if (a < b) return gcd(b, a)
    if (b == 0L) return a
    return gcd(b, a % b)
}

