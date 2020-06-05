package abc136

fun main(args: Array<String>) {
    val S = readLine()!! + "R"

    val ans = IntArray(S.length - 1)
    var now = 'R'
    var start = -1
    var rIndex = 0
    var lIndex = 0
    for (i in 1 until S.length) {
        if (now == 'R' && S[i] == 'L') {
            rIndex = i - 1
            lIndex = i
        }
        if (now == 'L' && S[i] == 'R') {
            if ((i - 1 - start) % 2 == 0) {
                ans[rIndex] = (i - 1 - start) / 2
                ans[lIndex] = (i - 1 - start) / 2
            } else {
                if ((rIndex - start) % 2 == 1) {
                    ans[rIndex] = (i - 1 - start) / 2 + 1
                    ans[lIndex] = (i - 1 - start) / 2
                } else {
                    ans[rIndex] = (i - 1 - start) / 2
                    ans[lIndex] = (i - 1 - start) / 2 + 1
                }
            }
            rIndex = 0
            lIndex = 0
            start = i - 1
        }
        now = S[i]
    }

    println(ans.joinToString(separator = " "))
}