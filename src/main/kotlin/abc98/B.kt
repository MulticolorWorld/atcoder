package abc98

fun main(arg: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    var ans = 0
    for (i in 1 until n) {
        var max = 0
        val s1 = s.substring(0, i).toCharArray().distinct()
        val s2 = s.substring(i, n).toCharArray().distinct()

        for (j in s1) {
            for (k in s2) {
                if (j == k) max++
            }
        }
        if (ans < max) ans = max
    }
    println(ans)
}