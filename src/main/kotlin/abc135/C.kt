package abc135

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map(String::toInt).toIntArray()
    val b = readLine()!!.split(" ").map(String::toInt).toIntArray()

    var ans = 0L
    for (i in 0 until n) {
        if (a[i] >= b[i]) {
            ans += b[i]
        } else if (a[i] + a[i + 1] < b[i]) {
            ans += (a[i] + a[i + 1])
            a[i + 1] = 0
        } else {
            ans += b[i]
            a[i + 1] -= (b[i] - a[i])
        }
    }
    println(ans)
}