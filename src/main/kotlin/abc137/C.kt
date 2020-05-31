package abc137

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val S = Array(N) { readLine()!! }

    val map = mutableMapOf<String, Long>()
    S.forEach { s ->
        val a = IntArray(26)
        s.forEach { c ->
            a[c - 'a']++
        }
        val key = a.joinToString(separator = "")
        map[key] = (map[key] ?: 0) + 1
    }

    var ans = 0L
    for (v in map.values) {
        ans += v * (v - 1) / 2
    }
    println(ans)
}