package abc113

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val array = Array(M) { i -> readLine()!!.split(" ").map { it.toInt() }.let { CityInfo(it[0], it[1], "", i) } }
    array.sortWith(compareBy({ it.p }, { it.birth }))

    var i = 1
    var city = array[0].p
    for (a in array) {
        if (city == a.p) {
            a.num = add0(a.p) + add0(i)
        } else {
            i = 1
            a.num = add0(a.p) + add0(i)
        }
        city = a.p
        i++
    }
    array.sortBy { it.order }
    array.map { it.num }.joinToString("\n").let { println(it) }
}

class CityInfo(
    val p: Int,
    val birth: Int,
    var num: String = "",
    val order: Int
)

fun add0(i: Int): String {
    if (i.toString().length < 6) {
        return "0".repeat(6 - i.toString().length) + i.toString()
    } else {
        return i.toString()
    }
}