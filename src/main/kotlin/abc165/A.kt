package abc165

fun main() {
    val k = readLine()!!.toInt()
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }

    var f = false
    for (i in a until b + 1) {
        if (i % k == 0) {
            f = true
        }
    }
    if (f) println("OK") else println("NG")
}