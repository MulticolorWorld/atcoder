package abc122

fun main(args: Array<String>) {
    val b = readLine()!!
    when (b) {
        "A" -> "T"
        "T" -> "A"
        "C" -> "G"
        "G" -> "C"
        else -> ""
    }.let { println(it) }
}
