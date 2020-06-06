package past3rd

fun main() {
    val (N, Q) = readLine()!!.split(" ").map { it.toInt() }
    val parent = IntArray(N + 1) { i -> i }
    val child = IntArray(N + 1) { i -> i }
    val bottom = IntArray(N + 1) { i -> i }
    val top = IntArray(N + 1) { i -> i }

    repeat(Q) {
        val (F, T, X) = readLine()!!.split(" ").map { it.toInt() }
        val subTop = top[F]
        if (bottom[F] == X) {
            bottom[F] = 0
            top[F] = 0
        } else {
            parent[child[X]] = child[X]
            top[F] = child[X]
        }
        if (bottom[T] == 0) {
            bottom[T] = X
            top[T] = subTop
        } else {
            parent[top[T]] = X
            child[X] = top[T]
            top[T] = subTop
        }
    }

    val place = IntArray(N + 1)
    for (i in 1 until N + 1) {
        var x = bottom[i]
        if (x != 0) {
            while (x != parent[x]) {
                place[x] = i
                x = parent[x]
            }
        }
        place[x] = i
    }
    for (i in 1 until N + 1) {
        println(place[i])
    }
}