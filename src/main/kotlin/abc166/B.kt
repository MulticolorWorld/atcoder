package abc166

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val aList = mutableListOf<List<Int>>()
    for (i in 0 until k) {
        val d = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map { it.toInt() }
        aList.add(a.toList())
    }

    val f = Array(n) { true }
    aList.forEach { a ->
        a.forEach { f[it - 1] = false }
    }
    println(f.filter { it }.size)
}