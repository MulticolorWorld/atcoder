package tokiomarine2020

fun main() {
    val (A, V) = readLine()!!.split(" ").map { it.toLong() }
    val (B, W) = readLine()!!.split(" ").map { it.toLong() }
    val T = readLine()!!.toLong()
    if (W >= V) {
        println("NO")
    } else {
        val l = Math.abs(A - B)
        val v = V - W
        if (v * T >= l) {
            println("YES")
        } else {
            println("NO")
        }
    }
}