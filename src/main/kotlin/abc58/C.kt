package abc58

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = Array(n) { readLine()!! }
    val map = mutableMapOf<Char, Int>()
    var c = 'a'
    while (c <= 'z') {
        map.put(c, s.map { it.filter { it == c }.count() }.min() ?: 0)
        c++
    }

    var ans = ""
    c = 'a'
    while (c <= 'z') {
        repeat(map[c]!!) {
            ans += c
        }
        c++
    }
    println(ans)
}