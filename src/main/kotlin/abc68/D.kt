package abc68

fun main(args: Array<String>) {
    val k = readLine()!!.toLong()
    val a = LongArray(50)
    for (i in a.indices) {
        a[i] = i + 1L
    }
    repeat((50 - k % 50).toInt()) {
        val maxIndex = a.indexOf(a.max()!!)
        for (i in a.indices) {
            if (i == maxIndex) {
                a[i] = a[i] - 50
            } else {
                a[i] = a[i] + 1
            }
        }
    }
    for (i in a.indices) {
        a[i] = a[i] + k / 50
    }
    println(50)
    println(a.joinToString(separator = " "))
}