package abc105

fun main(args: Array<String>) {
    var N = readLine()!!.toLong()
    val s = StringBuilder()
    while (N != 0L) {
        if (N % 2 != 0L) {
            N -= 1
            s.append(1)
        } else {
            s.append(0)
        }
        N /= -2
    }
    println(if (s.isEmpty()) 0 else s.reverse().toString())
}