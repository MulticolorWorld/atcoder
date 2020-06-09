package agc32

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val pair = Array((N + 1) / 2) { mutableSetOf<Int>() }
    if (N % 2 == 0) {
        for (i in 1..N / 2) {
            pair[i - 1].add(i)
            pair[i - 1].add(N - i + 1)
        }
    } else {
        for (i in 1..(N - 1) / 2) {
            pair[i - 1].add(i)
            pair[i - 1].add(N - i)
        }
        pair[(N + 1) / 2 - 1].add(N)
    }

    val v = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until pair.size - 1) {
        pair[i].forEach { p1 ->
            pair[i + 1].forEach { p2 ->
                v.add(Pair(p1, p2))
            }
        }
    }
    if (pair.size > 2) {
        pair[pair.size - 1].forEach { p1 ->
            pair[0].forEach { p2 ->
                v.add(Pair(p1, p2))
            }
        }
    }

    println(v.size)
    println(v.map { "${it.first} ${it.second}" }.joinToString(separator = "\n"))
}