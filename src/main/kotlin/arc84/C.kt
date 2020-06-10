package arc84

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val B = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sortedArray()
    val C = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sortedArray()

    var ans = 0L
    for (b in B) {
        //Aに対してbより真に小さいものを探す
        var l = -1
        var r = N
        while (r - l > 1) {
            val m = l + (r - l) / 2
            if (A[m] >= b) {
                r = m
            } else {
                l = m
            }
        }
        val a = r

        //Cに対してbより真に大きいものを探す
        l = -1
        r = N
        while (r - l > 1) {
            val m = l + (r - l) / 2
            if (C[m] > b) {
                r = m
            } else {
                l = m
            }
        }
        val c = N - r

        ans += a.toLong() * c.toLong()
    }
    println(ans)
}