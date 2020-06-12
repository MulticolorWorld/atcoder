package abc156

fun main(args: Array<String>) {
    val (N, A, B) = readLine()!!.split(" ").map { it.toInt() }
    val mod = 1000000007
    val com = COM(mod, 2 * 100000 + 1)
    com.modPow(2, N).let {
        val k = it - com.calculateLarge(N.toLong(), A)
        if (k < 0) {
            k + mod
        } else {
            k % mod
        }
    }.let {
        val k = it - com.calculateLarge(N.toLong(), B)
        if (k < 0) {
            k + mod
        } else {
            k % mod
        }
    }.let {
        val k = it - 1
        if (k < 0) {
            k + mod
        } else {
            k % mod
        }
    }.let { println(it) }
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

    fun calculate(n: Int, k: Int): Long {
        return fac[n] * (finv[k] * finv[n - k] % mod) % mod
    }

    fun calculateLarge(n: Long, k: Int): Long {
        var x = n
        var num = 1L
        repeat(k) {
            num = (num * x) % mod
            x--
        }
        return num * finv[k] % mod
    }

    fun modPow(x: Int, n: Int): Long {
        if (n == 1) {
            return x.toLong()
        }
        if (n % 2 == 0) {
            val k = modPow(x, n / 2) % mod
            return k * k % mod
        } else {
            val k = modPow(x, (n - 1) / 2) % mod
            return (x * k * k) % mod
        }
    }
}