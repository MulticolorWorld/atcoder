package abc76

fun main(args: Array<String>) {
    var s = readLine()!!
    val t = readLine()!!
    if (t.length > s.length) {
        println("UNRESTORABLE")
        return
    }

    for (i in s.length - t.length downTo 0) {
        var f = true
        var si = i
        for (j in 0 until t.length) {
            f = f && (s[si] == '?' || s[si] == t[j])
            si++
        }
        if (f) {
            s = s.replaceRange(i, i + t.length, t)
            s = s.replace('?', 'a')
            println(s)
            return
        }
    }
    println("UNRESTORABLE")
}