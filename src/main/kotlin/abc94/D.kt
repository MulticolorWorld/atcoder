package abc94

fun main(array: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }.sorted().toIntArray()

    val n = A.last()
    var min = Double.MAX_VALUE / 10
    var r = 0
    for (i in 0 until N - 1) {
        if (Math.abs(A[i] - n / 2) < min) {
            min = Math.abs(A[i] - n.toDouble() / 2)
            r = A[i]
        }
    }
    println("$n $r")
}