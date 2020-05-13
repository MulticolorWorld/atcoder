package abc49

fun main(args: Array<String>) {
    var s = readLine()!!

    while (s.isNotEmpty()) {
        when {
            s.endsWith("dream") -> {
                s = s.dropLast(5)
            }
            s.endsWith("dreamer") -> {
                s = s.dropLast(7)
            }
            s.endsWith("erase") -> {
                s = s.dropLast(5)
            }
            s.endsWith("eraser") -> {
                s = s.dropLast(6)
            }
            else -> {
                println("NO")
                return
            }
        }
    }
    println("YES")
}