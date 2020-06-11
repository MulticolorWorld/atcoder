package abc145

fun main(args: Array<String>) {
    val (X, Y) = readLine()!!.split(" ").map { it.toInt() }
    if ((2 * X - Y) % 3 != 0 || (2 * Y - X) % 3 != 0) {
        println(0)
    } else {
        val x = (2 * X - Y) / 3
        val y = (2 * Y - X) / 3
        if (x >= 0 && y >= 0) {
            val c = COM(1000000007, x + y + 1)
            println(c.com(x + y, x))
        } else {
            println(0)
        }
    }
}

class COM(
    val mod: Int,
    val max: Int
) {
    val fac = LongArray(max)
    val finv = LongArray(max)
    val inv = LongArray(max)

    init {
        fac[0] = 1
        fac[1] = 1
        finv[0] = 1
        finv[1] = 1
        inv[1] = 1

        for (i in 2 until max) {
            fac[i] = fac[i - 1] * i % mod
            inv[i] = mod - (inv[mod % i] * (mod / i)) % mod
            finv[i] = finv[i - 1] * inv[i] % mod
        }
    }

    fun com(n: Int, k: Int): Long {
        return fac[n] * (finv[k] * finv[n - k] % mod) % mod
    }
}