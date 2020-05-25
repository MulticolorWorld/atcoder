package abc118

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map(String::toInt)

    var ans = A[0]
    for (i in 1 until N) {
        ans = gcd(ans, A[i])
    }
    println(ans)
}

fun gcd(a: Int, b: Int): Int {
    if (a < b) return gcd(b, a)
    if (b == 0) return a
    return gcd(b, a % b)
}