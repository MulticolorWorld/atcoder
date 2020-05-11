package abc106

fun main(args: Array<String>) {
    val s = readLine()!!.toCharArray().map { it.toString() }.map { it.toInt() }.toIntArray()
    val k = readLine()!!.toLong()
    var f = 0L
    for (i in s.indices) {
        if (s[i] == 1) {
            f++
            if (f == k) {
                println(1)
                return
            }
        } else {
            println(s[i])
            return
        }
    }
}