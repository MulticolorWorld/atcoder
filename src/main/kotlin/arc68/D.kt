package arc68

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val count = IntArray(100001)
    A.forEach {
        count[it]++
    }
    var evenCount = 0
    var all = 0
    for (i in count.indices) {
        if (count[i] != 0) {
            if (count[i] % 2 == 0) {
                evenCount++
            }
            all++
        }
    }
    if (evenCount % 2 == 0) {
        println(all)
    } else {
        println(all - 1)
    }
}