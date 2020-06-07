package abc146

fun main(args: Array<String>) {
    val (A, B, X) = readLine()!!.split(" ").map { it.toLong() }

    fun search(): Long {
        var l = -1L
        var r = 1000000001L
        while (r - l > 1) {
            val m = l + (r - l) / 2
            if (X < A * m + B * m.toString().length) {
                r = m
            } else {
                l = m
            }
        }
        return l
    }

    search().let {
        if (it < 0) {
            0
        } else if (it > 1000000000) {
            1000000000
        } else {
            it
        }
    }.let { println(it) }
}

