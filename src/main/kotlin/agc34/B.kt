package agc34

fun main(args: Array<String>) {
    var s = readLine()!!
    s = s.replace("BC", "D") + "Z"

    val count = LongArray(s.length + 1)
    val inv = LongArray(s.length + 1)
    var ans = 0L
    for (i in s.indices) {
        if (s[i] == 'D') {
            count[i + 1] = count[i]
            inv[i + 1] = inv[i] + count[i]
        } else if (s[i] == 'A') {
            count[i + 1] = count[i] + 1
            inv[i + 1] = inv[i]
        } else {
            count[i + 1] = 0
            ans += inv[i]
            inv[i + 1] = 0
        }
    }
    println(ans)
}