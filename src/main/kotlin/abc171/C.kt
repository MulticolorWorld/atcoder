package abc171

fun main() {
    val N = readLine()!!.toLong()
    val E = 26L

    var digit = 0
    var n = N
    var e = E
    while (n > 0) {
        digit++
        n -= e
        e *= 26
    }

    e /= 26
    n += e
    n--
    val s = StringBuilder()
    do {
        val rem = (n % E).toInt()
        s.append('a' + rem)
        n /= E
    } while (n > 0)
    while (s.length < digit) {
        s.append("a")
    }
    println(s.toString().reversed())
}