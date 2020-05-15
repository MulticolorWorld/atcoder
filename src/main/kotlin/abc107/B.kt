package abc107

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(h) { readLine()!!.toCharArray().map { it.toString() }.toTypedArray() }

    for (i in 0 until h) {
        var f = false
        for (j in 0 until w) {
            f = f || a[i][j] == "#"
        }
        if (!f) {
            for (j in 0 until w) {
                a[i][j] = ""
            }
        }
    }

    for (j in 0 until w) {
        var f = false
        for (i in 0 until h) {
            f = f || a[i][j] == "#"
        }
        if (!f) {
            for (i in 0 until h) {
                a[i][j] = ""
            }
        }
    }

    for (i in 0 until h) {
        a[i].joinToString(separator = "").let {
            if (it.isNotEmpty()) {
                println(it)
            }
        }
    }
}