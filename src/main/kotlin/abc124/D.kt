package abc124

fun main(args: Array<String>) {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val S = readLine()!! + "2"

    val bitList = mutableListOf<Char>()
    val countList = mutableListOf<Long>(0)

    var bit = S[0]
    var count = 1L
    for (i in 1 until S.length) {
        if (bit == S[i]) {
            count++
        } else {
            bitList.add(bit)
            countList.add(count)
            bit = S[i]
            count = 1
        }
    }
    for (i in 1 until countList.size) {
        countList[i] += countList[i - 1]
    }

    var max = 0L
    for (i in 0 until bitList.size) {
        if (bitList[i] == '0') {
            max = Math.max(max, countList[Math.min(2 * K + i, countList.size - 1)] - countList[i])
        } else {
            max = Math.max(max, countList[Math.min(2 * K + 1 + i, countList.size - 1)] - countList[i])
        }
    }
    println(max)
}