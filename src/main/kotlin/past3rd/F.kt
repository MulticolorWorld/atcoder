package past3rd

fun main() {
    val N = readLine()!!.toInt()
    val A = Array(N) { readLine()!! }
    val s = StringBuilder()
    for (i in 0 until N / 2) {
        var c = 'a'
        while (c <= 'z') {
            if (A[i].contains(c) && A[N - 1 - i].contains(c)) {
                s.append(c)
                break
            }
            c++
        }
        if (c > 'z') {
            println(-1)
            return
        }
    }
    if (N % 2 == 0) {
        println(s.toString() + s.toString().reversed())
    } else {
        println(s.toString() + A[(N - 1) / 2][0] + s.toString().reversed())
    }
}