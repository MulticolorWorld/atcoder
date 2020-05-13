package abc157

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val s = IntArray(m)
    val c = IntArray(m)
    for (i in 0 until m) {
        readLine()!!.split(" ").map { it.toInt() }.let {
            s[i] = it[0] - 1
            c[i] = it[1]
        }
    }
    for (i in (if (n == 1) 0 else pow(10, n - 1)) until pow(10, n)) {
        (0 until m).map {
            i.toString()[s[it]].toString().toInt() == c[it]
        }.all {
            it
        }.let {
            if (it) {
                println(i)
                return
            }
        }
    }
    println(-1)
}

fun pow(a: Int, b: Int): Int {
    return Math.pow(a.toDouble(), b.toDouble()).toInt()
}