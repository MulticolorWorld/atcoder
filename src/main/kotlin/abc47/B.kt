package abc47

fun main(args: Array<String>) {
    val (w, h, n) = readLine()!!.split(" ").map { it.toInt() }
    val list = Array(n) {
        readLine()!!.split(" ").map { it.toInt() }.let { Triple(it[0], it[1], it[2]) }
    }

    val xMin = list.filter { it.third == 1 }.map { it.first }.max() ?: 0
    val xMax = list.filter { it.third == 2 }.map { it.first }.min() ?: w
    val yMin = list.filter { it.third == 3 }.map { it.second }.max() ?: 0
    val yMax = list.filter { it.third == 4 }.map { it.second }.min() ?: h
    println(
        if (xMax < xMin || yMax < yMin) {
            0
        } else {
            (xMax - xMin) * (yMax - yMin)
        }
    )
}