package lib

fun bitFullSearch(n: Int) {
    for (i in 0 until (1 shl n)) {
        for (j in 0 until n) {
            if (i.shr(j).and(1) == 1) {
            }
        }
    }
}