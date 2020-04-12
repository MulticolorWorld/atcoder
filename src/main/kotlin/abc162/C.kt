package abc162

fun main() {
    val k = readLine()!!.toInt()

    var ans = 0L
    for (a in 1 until k + 1) {
        for (b in 1 until k + 1) {
            for (c in 1 until k + 1) {
                ans += gcd(a, b, c)
            }
        }
    }
    println(ans)
}

fun gcd(a: Int, b: Int): Int {
    if (a < b) return gcd(b, a)
    if (b == 0) return a
    return gcd(b, a % b)
}

fun gcd(a: Int, b: Int, c: Int): Int {
    return gcd(a, gcd(b, c))
}