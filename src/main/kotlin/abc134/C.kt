package abc134

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = Array(n) { i -> Pair(i, readLine()!!.toInt()) }
    a.sortByDescending { it.second }
    val max = a[0]
    val prevMax = a[1]
    for (i in a.indices) {
        if (i == max.first) {
            println(prevMax.second)
        } else {
            println(max.second)
        }
    }
}