package abc97

fun main(args: Array<String>) {
    val s = readLine()!!
    val k = readLine()!!.toInt()
    val list = mutableListOf<String>()
    var i = 0
    while (i < k) {
        for (j in 0 until s.length - i) {
            val sub = s.slice(j..j + i)
            if (!list.contains(sub)) {
                list.add(sub)
            }
        }
        i++
    }
    list.sort()
    println(list[k - 1])
}