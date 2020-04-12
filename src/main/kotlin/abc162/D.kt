package abc162

fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!.toCharArray()

    var max = s.filter { it == 'R' }.size.toLong() *
            s.filter { it == 'G' }.size.toLong() *
            s.filter { it == 'B' }.size.toLong()

    for (i in 1 until s.size) {
        for (j in 0 until i) {
            val k = 2 * i - j
            if (k >= s.size) continue
            if (s[i] != s[j] && s[j] != s[k] && s[k] != s[i]) max--
        }
    }

    println(max)
}

