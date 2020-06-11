package lib

fun IntArray.binarySearch(key: Int): Int {
    var l = -1
    var r = this.size
    while (r - l > 1) {
        val m = l + (r - l) / 2
        if (this[m] < key) {
            r = m
        } else {
            l = m
        }
    }
    return r
}