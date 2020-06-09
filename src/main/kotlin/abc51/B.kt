package abc51

fun main(args: Array<String>) {
    val (K, S) = readLine()!!.split(" ").map { it.toInt() }
    var count = 0L
    for (x in 0..K) {
        for (y in 0..K) {
            val z = S - x - y
            if (z in 0..K) {
                count++
            }
        }
    }
    println(count)
}