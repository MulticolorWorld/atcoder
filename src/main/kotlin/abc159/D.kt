package abc159

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }

    val countArray = LongArray(200000) { 0 }
    a.forEach { countArray[it]++ }
    val ans = countArray.map { it * (it - 1) / 2 }.sum()
    for (i in 0 until n) {
        val count = countArray[a[i]]
        println(ans - count + 1)
    }
}