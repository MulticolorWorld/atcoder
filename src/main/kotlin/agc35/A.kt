package agc35

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    for (a in A) {
        map[a] = (map[a] ?: 0) + 1
    }
    var f = false
    if ((map[0] ?: 0) == N) {
        f = true
    } else if (N % 3 == 0) {
        val keys = map.keys.toList()
        if (keys.size == 2 && keys.contains(0)) {
            f = keys.map { k ->
                if (k == 0) {
                    map[k]!! == N / 3
                } else {
                    map[k]!! == 2 * N / 3
                }
            }.all { it }
        } else if (map.keys.size == 3) {
            f = keys[0].xor(keys[1].xor(keys[2])) == 0
                    && map[keys[0]]!! == map[keys[1]]!!
                    && map[keys[1]]!! == map[keys[2]]!!
        }
    }
    if (f) {
        println("Yes")
    } else {
        println("No")
    }
}