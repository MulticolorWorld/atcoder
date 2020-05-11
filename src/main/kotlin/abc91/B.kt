package abc91

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = (0 until n).map {
        readLine()!!
    }.toTypedArray()
    val m = readLine()!!.toInt()
    val t = (0 until m).map {
        readLine()!!
    }.toTypedArray()

    val map = mutableMapOf<String, Int>()
    s.forEach {
        if (map.containsKey(it)) {
            map.set(it, map[it]!! + 1)
        } else {
            map.set(it, 1)
        }
    }
    t.forEach {
        if (map.containsKey(it)) {
            map.set(it, map[it]!! - 1)
        }
    }
    map.values.toIntArray().max()!!.let {
        if (it < 0) println(0) else println(it)
    }
}