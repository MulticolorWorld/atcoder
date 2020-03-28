package abc159

fun main(array: Array<String>) {
    val s = readLine()!!
    val s1 = s.substring(0, (s.length - 1) / 2)
    val s2 = s.substring((s.length + 3) / 2 - 1, s.length)
    if (s == s.reversed() && s1 == s1.reversed() && s2 == s2.reversed()) {
        println("Yes")
    } else {
        println("No")
    }
}