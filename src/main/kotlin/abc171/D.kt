package abc171

fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }

    val map = mutableMapOf<Long, Long>()
    A.forEach { a ->
        map[a] = (map[a] ?: 0) + 1
    }
    var rec = A.sum()

    val Q = readLine()!!.toInt()
    repeat(Q) {
        val (B, C) = readLine()!!.split(" ").map { it.toLong() }
        if (map.containsKey(B)) {
            rec += (C - B) * map[B]!!
            map[C] = (map[C] ?: 0) + (map[B] ?: 0)
            map[B] = 0
        }
        println(rec)
    }
}