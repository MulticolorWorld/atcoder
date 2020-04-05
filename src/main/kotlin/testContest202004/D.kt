package testContest202004

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!.split(" ").map { it.toInt() }

    val aAccum = Array(a.size) { 0 }
    aAccum[0] = a[0]
    for (i in 1 until a.size) {
        aAccum[i] = gcd(aAccum[i - 1], a[i])
    }

    for (se in s) {
        if (gcd(se, aAccum.last()) != 1) {
            println(gcd(se, aAccum.last()))
        } else {
            var l = 0
            var r = aAccum.size - 1
            while (l < r) {
                val c = l + (r - l) / 2
                if (gcd(aAccum[c], se) == 1) {
                    r = c
                } else {
                    l = c + 1
                }
            }
            println(l + 1)
        }
    }
}

fun gcd(a: Int, b: Int): Int {
    if (a < b) return gcd(b, a)
    if (b == 0) return a
    return gcd(b, a % b)
}