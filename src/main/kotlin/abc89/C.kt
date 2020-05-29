package abc89

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val count = LongArray(5)
    repeat(N) {
        val S = readLine()!!
        when (S[0]) {
            'M' -> count[0]++
            'A' -> count[1]++
            'R' -> count[2]++
            'C' -> count[3]++
            'H' -> count[4]++
        }
    }

    val list = mutableListOf<String>()
    fun comGenerate(index: Int, s: String) {
        if (index == 5) {
            if (s.length == 3) {
                list.add(s)
            }
            return
        }
        comGenerate(index + 1, s + index)
        comGenerate(index + 1, s)
    }
    comGenerate(0, "")

    list.map { s ->
        s.map { c ->
            count[c.toString().toInt()]
        }.reduce { acc, l -> acc * l }
    }.sum().let { println(it) }
}