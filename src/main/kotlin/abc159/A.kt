package abc159

fun main(args: Array<String>) {
    val a = readLine()!!.split(" ").map { it.toInt() }
    val n = a[0].let { if (it == 0) 1 else it }
    val m = a[1].let { if (it == 0) 1 else it }

    println(n * (n - 1) / 2 + m * (m - 1) / 2)
}



