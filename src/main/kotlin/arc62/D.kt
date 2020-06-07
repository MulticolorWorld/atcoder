package arc62

fun main(args: Array<String>) {
    val S = readLine()!!
    val pCount = S.filter { it == 'p' }.length
    println(S.length / 2 - pCount)
}