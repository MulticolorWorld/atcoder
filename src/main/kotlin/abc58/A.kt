package abc58

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map(String::toInt)
    if (b - a == c - b) {
        println("YES")
    } else {
        println("NO")
    }
}