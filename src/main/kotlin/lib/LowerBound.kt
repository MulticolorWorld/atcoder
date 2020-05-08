package lib

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