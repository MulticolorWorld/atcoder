package yorukatsu27

fun main(args: Array<String>) {
    val a = readLine()!!.toCharArray().map { it.toString() }.map { it.toInt() }
    for (i in 0 until (1 shl 3)) {
        val op = Array(3) { "" }
        var ans = a[0]
        for (j in 0 until 3) {
            if (i.shr(j).and(1) == 1) {
                op[j] = "+"
                ans += a[j + 1]
            } else {
                op[j] = "-"
                ans -= a[j + 1]
            }
        }
        if (ans == 7) {
            println("${a[0]}${op[0]}${a[1]}${op[1]}${a[2]}${op[2]}${a[3]}=7")
            break
        }
    }
}