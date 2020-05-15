package abc116

fun main(args: Array<String>) {
    readLine()!!.split(" ").map { it.toInt() }.let {
        println(it[0] * it[1] / 2)
    }
}