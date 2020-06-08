package abc109

fun main(args: Array<String>) {
    val (H, W) = readLine()!!.split(" ").map { it.toInt() }
    val A = Array(H) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    val opList = mutableListOf<Operation>()

    var x = 0
    var y = 0
    var now = false
    var counter = 0
    while (counter < H * W - 1) {
        val xNext =
            if (x == W - 1 && y % 2 == 0) {
                x
            } else if (x == 0 && y % 2 == 1) {
                x
            } else if (y % 2 == 0) {
                x + 1
            } else {
                x - 1
            }
        val yNext =
            if (x == W - 1 && y % 2 == 0) {
                y + 1
            } else if (x == 0 && y % 2 == 1) {
                y + 1
            } else {
                y
            }
        if (A[y][x] % 2 == 1 && now) {
            now = false
        } else if (A[y][x] % 2 == 1 && !now) {
            now = true
            opList.add(Operation(y, x, yNext, xNext))
        } else if (A[y][x] % 2 == 0 && now) {
            opList.add(Operation(y, x, yNext, xNext))
        }
        x = xNext
        y = yNext
        counter++
    }
    println(opList.size)
    opList.forEach { op -> println("${op.y1 + 1} ${op.x1 + 1} ${op.y2 + 1} ${op.x2 + 1}") }
}

class Operation(
    val y1: Int,
    val x1: Int,
    val y2: Int,
    val x2: Int
)