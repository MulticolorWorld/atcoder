package yorukatsu21

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val lArray = readLine()!!.split(" ").map { it.toInt() }.sorted()

    var ans = 0
    for (i in 0 until lArray.size - 2) {
        for (j in i + 1 until lArray.size - 1) {
            val array = lArray.subList(j + 1, lArray.size)
            val min = lArray[j] - lArray[i]
            val max = lArray[j] + lArray[i]
            ans += lowerBound(array, max) - lowerBound(array, min)
        }
    }
    println(ans)
}

fun lowerBound(list: List<Int>, value: Int): Int {
    var low = 0
    var high = list.size
    while (low < high) {
        val mid = (low + high) / 2
        if (value <= list[mid]) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}