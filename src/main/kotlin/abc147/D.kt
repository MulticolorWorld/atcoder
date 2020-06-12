package abc147

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }
    val mod = 1000000007

    var res = 0L
    var twoFactor = 1L
    for (d in 0 until 60) {
        var even = 0L
        var odd = 0L
        for (i in 0 until N) {
            if ((A[i] shr d) and 1L == 1L) {
                odd++
            } else {
                even++
            }
        }
        val add = (((odd * even) % mod) * twoFactor) % mod
        res = (res + add) % mod
        twoFactor = (twoFactor * 2) % mod
    }
    println(res)
}