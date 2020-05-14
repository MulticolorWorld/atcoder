package abc66

fun main(args: Array<String>) {
    var s = readLine()!!
    while (s.isNotEmpty()) {
        s = s.dropLast(2)
        if (s.slice(0..s.length / 2 - 1) == s.slice(s.length / 2..s.length - 1)) {
            println(s.length)
            return
        }
    }
}