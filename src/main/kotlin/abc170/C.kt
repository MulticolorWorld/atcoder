package abc170

fun main() {
    val (X, N) = readLine()!!.split(" ").map { it.toInt() }
    var P = readLine()!!

    if (P.isEmpty()) {
        println(X)
        return
    }
    val p = P.split(" ").map { it.toInt() }

    var i = 0
    while (true) {
        if (!p.contains(X - i)) {
            println(X - i)
            return
        }
        if (!p.contains(X + i)) {
            println(X + i)
            return
        }
        i++
    }
}