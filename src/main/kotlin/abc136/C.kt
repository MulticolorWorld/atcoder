package abc136

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val h = readLine()!!.split(" ").map(String::toLong).reversed().toLongArray()
    for (i in 1 until n) {
        if (h[i] - h[i - 1] > 1L) {
            println("No")
            return
        }
        if (h[i] - h[i - 1] == 1L) {
            h[i]--
        }
    }
    println("Yes")
}