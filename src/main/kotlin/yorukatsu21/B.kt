package yorukatsu21

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }

    var ans = 0
    for (ae in a) {
        var b = ae
        while (b % 2 == 0L) {
            b /= 2
            ans++
        }
    }
    println(ans)
}