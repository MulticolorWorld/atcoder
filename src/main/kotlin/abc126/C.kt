package abc126

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }

    var sum = 0.0
    for (i in 1..N) {
        var j = i
        var prob = 1 / N.toDouble()
        while (j < K) {
            j *= 2
            prob /= 2
        }
        sum += prob
    }
    println(sum)
}