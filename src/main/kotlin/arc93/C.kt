package arc93

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = intArrayOf(0) + readLine()!!.split(" ").map(String::toInt).toIntArray() + intArrayOf(0)

    var total = 0
    for (i in 1 until a.size) {
        total += Math.abs(a[i] - a[i - 1])
    }

    for (i in 1..n) {
        println(total - (Math.abs(a[i] - a[i - 1]) + Math.abs(a[i + 1] - a[i])) + Math.abs(a[i + 1] - a[i - 1]))
    }
}