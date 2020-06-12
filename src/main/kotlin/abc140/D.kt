package abc140

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val S = readLine()!! + "Z"
    val s = mutableListOf<Int>()

    var c = S[0]
    var count = 1
    for (i in 1 until S.length) {
        if (S[i] == c) {
            count++
        } else {
            s.add(count)
            count = 1
            c = S[i]
        }
    }

    var now = s.map { it - 1 }.sum()
    for (i in 0 until K) {
        val x = 2 * i + 1
        if (x > s.size - 1) {
            break
        } else if (x == s.size - 1) {
            now += 1
        } else {
            now += 2
        }
    }
    println(now)
}