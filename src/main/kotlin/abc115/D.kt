package abc115

fun main(args: Array<String>) {
    val (N, X) = readLine()!!.split(" ").map { it.toLong() }
    val num = LongArray(N.toInt() + 1)
    val pNum = LongArray(N.toInt() + 1)
    num[0] = 1
    pNum[0] = 1
    for (i in 1..N.toInt()) {
        num[i] = 2 * num[i - 1] + 3
        pNum[i] = 2 * pNum[i - 1] + 1
    }

    fun count(l: Int, x: Long): Long {
        if (num[l] == x) {
            return pNum[l]
        } else if (num[l] > x && x > (num[l] + 1) / 2) {
            return pNum[l - 1] + 1 + count(l - 1, x - (num[l] + 1) / 2)
        } else if ((num[l] + 1) / 2 == x) {
            return 1 + pNum[l - 1]
        } else if ((num[l] + 1) / 2 > x && x > 1) {
            return count(l - 1, x - 1)
        } else {
            return 0
        }
    }
    println(count(N.toInt(), X))
}