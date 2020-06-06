package past3rd

fun main() {
    val N = readLine()!!.toInt()
    val S = Array(5) { "." + readLine()!! }
    val s = StringBuilder()
    for (j in 1..N) {
        when {
            S[0][4 * j - 2] == '.' -> s.append("1")
            S[0][4 * j - 1] == '.' -> s.append("4")
            S[4][4 * j - 2] == '.' -> s.append("7")
            S[2][4 * j - 1] == '.' -> s.append("0")
            "" + S[1][4 * j - 2] + S[1][4 * j] + S[3][4 * j - 2] + S[3][4 * j] == ".##." -> s.append("2")
            "" + S[1][4 * j - 2] + S[1][4 * j] + S[3][4 * j - 2] + S[3][4 * j] == ".#.#" -> s.append("3")
            "" + S[1][4 * j - 2] + S[1][4 * j] + S[3][4 * j - 2] + S[3][4 * j] == "#..#" -> s.append("5")
            "" + S[1][4 * j - 2] + S[1][4 * j] + S[3][4 * j - 2] + S[3][4 * j] == "#.##" -> s.append("6")
            "" + S[1][4 * j - 2] + S[1][4 * j] + S[3][4 * j - 2] + S[3][4 * j] == "####" -> s.append("8")
            "" + S[1][4 * j - 2] + S[1][4 * j] + S[3][4 * j - 2] + S[3][4 * j] == "##.#" -> s.append("9")
        }
    }
    println(s.toString())
}