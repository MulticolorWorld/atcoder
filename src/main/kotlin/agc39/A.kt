package agc39

fun main(args: Array<String>) {
    val S = readLine()!!
    val K = readLine()!!.toLong()

    val init = check(S)
    val delta1 = check(S + S) - init
    val delta2 = check(S + S + S) - delta1 - init

    println(init + delta2 * (K / 2) + delta1 * ((K - 1) / 2))
}

fun check(s: String): Long {
    var now = s[0]
    var ans = 0L
    var counter = 1L
    for (i in 1 until s.length) {
        if (s[i] == now) {
            counter++
        } else {
            now = s[i]
            ans += counter / 2
            counter = 1L
        }
    }
    ans += counter / 2
    return ans
}