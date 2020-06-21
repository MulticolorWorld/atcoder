package abc171

fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val P = readLine()!!.split(" ").map { it.toInt() }.sorted()
    println(P.take(K).sum())
}