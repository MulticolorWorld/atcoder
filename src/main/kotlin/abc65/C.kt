package abc65

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val mod = 1000000007L

    if (Math.abs(b - a) >= 2) {
        println(0)
        return
    }
    var ans = 1L
    if (a == b) {
        for (i in 1..a) {
            ans = (ans * i) % mod
            ans = (ans * i) % mod
        }
        ans = (ans * 2) % mod
    } else {
        for (i in 1..a) {
            ans = (ans * i) % mod
        }
        for (i in 1..b) {
            ans = (ans * i) % mod
        }
    }
    println(ans % mod)
}