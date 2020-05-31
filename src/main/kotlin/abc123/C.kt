package abc123

fun main(args: Array<String>) {
    val N = readLine()!!.toLong()
    val capacity = LongArray(5) { readLine()!!.toLong() }
    val min = capacity.min()!!
    println((N + min - 1) / min + 4)
}