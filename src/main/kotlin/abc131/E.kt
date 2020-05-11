package abc131

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var max = (n - 1) * (n - 2) / 2
    if (max < k) {
        println(-1)
        return
    }

    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 2..n) {
        list.add(Pair(1, i))
    }
    loop@ for (i in 2..n - 1) {
        for (j in i + 1..n) {
            if (max != k) {
                list.add(Pair(i, j))
                max--
            } else {
                break@loop
            }
        }
    }
    println(list.size)
    list.forEach {
        println("${it.first} ${it.second}")
    }
}