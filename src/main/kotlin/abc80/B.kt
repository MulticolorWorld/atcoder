package abc80

fun main(args: Array<String>) {
    val n = readLine()!!
    if (n.toInt() % n.toCharArray().map { it.toString().toInt() }.sum() == 0) {
        println("Yes")
    } else {
        println("No")
    }
}