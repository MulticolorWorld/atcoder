package abc47

fun main(args: Array<String>) {
    val s = readLine()!!
    var ans = 0
    var now = s[0]
    for (i in 1 until s.length) {
        if (s[i] != now) {
            ans++
            now = s[i]
        }
    }
    println(ans)
}