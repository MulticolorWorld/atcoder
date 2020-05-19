package arc69

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    fun check(ss: String): String? {
        val builder = StringBuilder(ss)
        for (i in 1 until n) {
            if (s[i] == 'o' && builder[i] == 'S' || builder[i] == 'W' && s[i] == 'x') {
                builder.append(builder[i - 1])
            } else {
                builder.append(if (builder[i - 1] == 'S') 'W' else 'S')
            }
        }
        if (builder.first() != builder.last()) {
            return null
        } else {
            builder.deleteCharAt(builder.length - 1)
        }
        if ((s[0] == 'o' && builder[0] == 'S' || s[0] == 'x' && builder[0] == 'W') && builder.last() == builder[1]) {
            return builder.toString()
        }
        if ((s[0] == 'x' && builder[0] == 'S' || s[0] == 'o' && builder[0] == 'W') && builder.last() != builder[1]) {
            return builder.toString()
        }
        return null
    }

    println(check("SS") ?: check("SW") ?: check("WS") ?: check("WW") ?: -1)
}