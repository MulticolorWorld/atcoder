package abc165

fun main() {
    val x = readLine()!!.toLong()

    var i = 0
    var m = 100L
    while (m < x) {
        m = (m * 1.01).toLong()
        i++
    }
    println(i)
}