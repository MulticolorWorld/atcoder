package abc80

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }
    var draw = IntArray(0)
    for (i in 0 until n) {
        draw += IntArray(a[i]) { i + 1 }
    }

    val list = mutableListOf<IntArray>()
    for (i in 0 until h) {
        if (i % 2 == 0) {
            list.add(draw.slice(i * w until (i + 1) * w).toIntArray())
        } else {
            list.add(draw.slice(i * w until (i + 1) * w).reversed().toIntArray())
        }
    }

    list.forEach {
        println(it.joinToString(separator = " "))
    }
}