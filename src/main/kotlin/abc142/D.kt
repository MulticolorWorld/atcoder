package abc142

fun main(args: Array<String>) {
    val (A, B) = readLine()!!.split(" ").map { it.toLong() }
    var gcd = gcd(A, B)
    val set = mutableSetOf<Int>()
    set.add(1)
    for (i in 2..Math.sqrt(gcd.toDouble()).toInt()) {
        while (gcd % i == 0L) {
            gcd /= i
            set.add(i)
        }
    }
    set.add(gcd.toInt())
    println(set.size)
}

fun gcd(a: Long, b: Long): Long {
    if (a < b) return gcd(b, a)
    if (b == 0L) return a
    return gcd(b, a % b)
}