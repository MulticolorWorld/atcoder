package abc96

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val s = Array(h) { readLine()!! }
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (s[i][j] == '#') {
                var f = false
                if (i != 0) {
                    f = f || s[i - 1][j] == '#'
                }
                if (j != 0) {
                    f = f || s[i][j - 1] == '#'
                }
                if (i != h - 1) {
                    f = f || s[i + 1][j] == '#'
                }
                if (j != w - 1) {
                    f = f || s[i][j + 1] == '#'
                }
                if (!f) {
                    println("No")
                    return
                }
            }

        }
    }
    println("Yes")
}