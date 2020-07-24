package abc173

fun main() {
    val (H, W, K) = readLine()!!.split(" ").map { it.toInt() }
    val C = Array(H) { readLine()!!.toCharArray() }

    var ans = 0
    fun rec(s: String) {
        if (s.length != (H + W)) {
            rec(s + "0")
            rec(s + "1")
        } else {
            val hRed = s.slice(0 until H)
            val wRed = s.slice(H until H + W)
            var count = 0
            for (i in 0 until H) {
                for (j in 0 until W) {
                    if (C[i][j] == '#' && hRed[i] == '0' && wRed[j] == '0') count++
                }
            }
            if (count == K) ans++
        }
    }

    rec("")
    println(ans)
}