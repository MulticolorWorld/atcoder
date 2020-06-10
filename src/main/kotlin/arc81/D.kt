package arc81

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val s1 = readLine()!!
    val s2 = readLine()!!
    val mod = 1000000007
    var ans = 1L
    var i = 0
    var vh = 'v'
    if (s1[i] == s2[i]) {
        ans *= 3
        vh = 'v'
        i += 1
    } else {
        ans *= 6
        vh = 'h'
        i += 2
    }

    while (i < N) {
        if (s1[i] == s2[i]) {
            if (vh == 'v') {
                ans *= 2
                vh = 'v'
                i += 1
            } else {
                ans *= 1
                vh = 'v'
                i += 1
            }
        } else {
            if (vh == 'v') {
                ans *= 2
                vh = 'h'
                i += 2
            } else {
                ans *= 3
                vh = 'h'
                i += 2
            }
        }
    }
    println(ans % mod)
}