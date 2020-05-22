package abc154

fun main(args: Array<String>) {
    val (s, t) = readLine()!!.split(" ")
    var (a, b) = readLine()!!.split(" ").map(String::toInt)
    val u = readLine()!!
    if (s == u) {
        a--
    } else if (t == u) {
        b--
    }
    println("$a $b")
}