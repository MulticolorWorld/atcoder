package lib

import java.util.*

fun sieve(k: Int): TreeSet<Int> {
    val set = TreeSet<Int>()
    val f = BooleanArray(k + 1) { true }
    f[0] = false
    f[1] = false
    for (i in 2..k) {
        if (f[i]) {
            set.add(i)
            var j = 2 * i
            while (j <= k) {
                f[j] = false
                j += i
            }
        }
    }
    return set
}