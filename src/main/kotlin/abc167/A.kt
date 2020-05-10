package abc167

fun main() {
    val s = readLine()!!
    val t = readLine()!!
    if (s == t.substring(0, s.length)) {
        println("Yes")
    } else {
        println("No")
    }
}