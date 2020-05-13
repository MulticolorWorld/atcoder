package abc103

fun main(args: Array<String>) {
    var s = readLine()!!
    val t = readLine()!!
    repeat(s.length) {
        if (s == t) {
            println("Yes")
            return
        }
        s = s.last() + s.dropLast(1)
    }
    println("No")
}