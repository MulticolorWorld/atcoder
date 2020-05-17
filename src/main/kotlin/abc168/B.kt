package abc168

fun main() {
    val k = readLine()!!.toInt()
    var s = readLine()!!
    if (s.length > k) {
        s = s.slice(0 until k) + "..."
    }
    println(s)
}