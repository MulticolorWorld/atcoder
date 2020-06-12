package abc134

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = intArrayOf(0) + readLine()!!.split(" ").map { it.toInt() }

    val box = IntArray(N + 1)
    for (i in N downTo 1) {
        var x = i + i
        var sum = 0
        while (x in 0..N) {
            sum += box[x]
            x += i
        }
        if (sum % 2 != A[i]) {
            box[i] = 1
        }
    }

    box.mapIndexed { index, i ->
        Pair(index, i)
    }.filter {
        it.second == 1
    }.let {
        println(it.size)
        if (it.isNotEmpty()) {
            println(it.map { it.first }.joinToString(separator = " "))
        }
    }
}