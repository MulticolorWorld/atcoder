package past3rd

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val children = IntArray(N)
    val A = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    for (a in A) {
        val i = search(children, a)
        if (i < N) {
            println(i + 1)
            children[i] = a
        } else {
            println(-1)
        }

    }
}

fun search(a: IntArray, key: Int): Int {
    var l = -1
    var r = a.size
    while (r - l > 1) {
        val m = l + (r - l) / 2
        if (a[m] < key) {
            r = m
        } else {
            l = m
        }
    }
    return r
}