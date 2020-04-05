package testContest202004

fun main(args: Array<String>) {
    val (s, l, r) = readLine()!!.split(" ").map { it.toInt() }
    when {
        s < l -> {
            println(l)
        }
        r < s -> {
            println(r)
        }
        else -> {
            println(s)
        }
    }
}