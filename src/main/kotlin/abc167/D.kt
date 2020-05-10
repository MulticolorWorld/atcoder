package abc167

fun main() {
    var (n, k) = readLine()!!.split(" ").map { it.toLong() }
    val a = intArrayOf(0) + readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    var m = a[1]
    var mm = a[a[1]]
    while (m != mm) {
        m = a[m]
        mm = a[a[mm]]
    }
    var lambda = 0L
    var first = 1
    while (first != m) {
        first = a[first]
        m = a[m]
        lambda++
    }
    m = a[first]
    mm = a[a[first]]
    var myu = 1L
    while (m != mm) {
        m = a[m]
        mm = a[a[mm]]
        myu++
    }
    if (k >= lambda) {
        k -= lambda
        repeat((k % myu).toInt()) {
            m = a[m]
        }
    } else {
        m = 1
        repeat(k.toInt()) {
            m = a[m]
        }
    }

    println(m)
}