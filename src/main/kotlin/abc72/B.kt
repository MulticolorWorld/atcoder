package abc72

fun main(args: Array<String>) {
    val s = readLine()!!
    var ans = ""
    var i = 0
    while (i < s.length) {
        ans += s[i]
        i += 2
    }
    println(ans)
}