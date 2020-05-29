package abc82

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }

    val count = mutableMapOf<Int, Int>()
    A.forEach { a ->
        count[a] = (count[a] ?: 0) + 1
    }

    var ans = 0L
    for ((key, c) in count) {
        if (key < c) {
            ans += (c - key)
        }
        if (key > c) {
            ans += c
        }
    }
    println(ans)
}