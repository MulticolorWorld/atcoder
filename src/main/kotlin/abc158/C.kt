package abc158

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    for (i in 0..1000) {
        if ((i * 0.08).toInt() == a && (i * 0.1).toInt() == b) {
            println(i)
            return
        }
    }
    println(-1)
}