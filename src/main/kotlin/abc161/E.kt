package abc161

fun main(args: Array<String>) {
    val (n, k, c) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!.toList()

    var si = 0
    val l = mutableListOf<Int>()
    while (l.size != k) {
        if (s[si] == 'x') {
            si += 1
        } else {
            l.add(si)
            si += (c + 1)
        }
    }

    si = s.size - 1
    val r = mutableListOf<Int>()
    while (r.size != k) {
        if (s[si] == 'x') {
            si -= 1
        } else {
            r.add(si)
            si -= (c + 1)
        }
    }
    r.reverse()

    for (i in 0 until l.size) {
        if (l[i] == r[i]) {
            println(l[i] + 1)
        }
    }
}

