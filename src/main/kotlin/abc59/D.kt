package abc59

fun main(args: Array<String>) {
    val s = readLine()!!

    var n = 'a'
    while (n <= 'z') {
        val list = mutableListOf<Int>()
        for (i in s.indices) {
            if (s[i] == n) {
                list.add(i)
            }
        }
        list.sort()
        for (i in 0 until list.size - 1) {
            if (list[i + 1] - list[i] <= 2) {
                println("${list[i] + 1} ${list[i + 1] + 1}")
                return
            }
        }
        n++
    }
    println("-1 -1")
}