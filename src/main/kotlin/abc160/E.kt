package abc160

fun main(args: Array<String>) {
    val (x, y, a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    val p = readLine()!!.split(" ").map { it.toLong() }.sorted().reversed()
    val q = readLine()!!.split(" ").map { it.toLong() }.sorted().reversed()
    val r = readLine()!!.split(" ").map { it.toLong() }.sorted().reversed()

    val p1 = p.take(x)
    val q1 = q.take(y)
    val ans = (p1 + q1 + r).sorted().reversed().take(x + y).sum()
    println(ans)
}