package abc170

fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }.sorted().toIntArray()

    val max = A.max()!!

    val dp = BooleanArray(max + 1) { true }
    val searched = BooleanArray(max + 1) { false }
    A.forEach { it ->
        var a = it
        if (searched[a]) {
            dp[a] = false
            return@forEach
        }
        searched[a] = true
        var i = a * 2
        while (i <= max) {
            dp[i] = false
            i += a
        }
    }

    A.filter { a ->
        dp[a]
    }.size.let {
        println(it)
    }
}