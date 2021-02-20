package abc192

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    var i = 0
    var ai = N
    while (i != K){
        val g1 = ai.toString().toCharArray().sortedArrayDescending().let { String(it) }.toInt()
        val g2 = ai.toString().toCharArray().sortedArray().let { String(it) }.toInt()
        ai = g1 - g2
        i++
    }
    println(ai)
}