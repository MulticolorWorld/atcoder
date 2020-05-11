package abc131

fun main(args: Array<String>) {
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toLong() }
    val divC = (b / c) - (a - 1) / c
    val divD = (b / d) - (a - 1) / d
    val gcd = gcd(c, d)
    val divCD = ((b / (c * d / gcd)) - (a - 1) / (c * d / gcd))
    val count = b - (a - 1)

    println(count - (divC + divD - divCD))
}

fun gcd(a: Long, b: Long): Long {
    if (a < b) return gcd(b, a)
    if (b == 0L) return a
    return gcd(b, a % b)
}