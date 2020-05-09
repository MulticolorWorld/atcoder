package yorukatsu36

fun main(args: Array<String>) {
    val s = readLine()!!
    var ans = s.toLong()
    for (i in 1 until (1 shl s.length - 1)) {
        var ss = ""
        for (j in s.indices) {
            ss += s[j]
            if (i.shr(j).and(1) == 1) {
                ans += ss.toLong()
                ss = ""
            }
        }
        if (ss.isNotBlank()) ans += ss.toLong()
    }
    println(ans)
}