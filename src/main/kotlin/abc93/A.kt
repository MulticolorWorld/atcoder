package abc93

fun main(args: Array<String>) {
    val s = readLine()!!.toString()
    if (s.contains("a") && s.contains("b") && s.contains("c")) println("Yes") else println("No")
}