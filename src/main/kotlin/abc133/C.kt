package abc133

fun main(args: Array<String>) {
    val (l, r) = readLine()!!.split(" ").map { it.toInt() }

    if (l / 2019 != r / 2019) {
        println(0)
    } else {
        var min = Long.MAX_VALUE / 10
        for (i in l..r - 1) {
            for (j in i + 1..r) {
                min = Math.min(min, (i % 2019L) * (j % 2019L) % 2019L)
            }
        }
        println(min)
    }
}