package yorukatsu34

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!

    if (check(s, t) && check(t, s)) {
        println("Yes")
    } else {
        println("No")
    }
}

fun check(s: String, t: String): Boolean {
    val map = mutableMapOf<Char, Char>()
    for (i in s.indices) {
        if (!map.containsKey(s[i])) {
            map[s[i]] = t[i]
        } else {
            if (map[s[i]] == t[i]) {
                continue
            } else {
                return false
            }
        }
    }
    return true
}