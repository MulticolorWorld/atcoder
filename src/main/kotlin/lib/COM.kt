package lib

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