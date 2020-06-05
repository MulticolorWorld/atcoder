package abc51

fun main(args: Array<String>) {
    val (SX, SY, TX, TY) = readLine()!!.split(" ").map { it.toInt() }
    val go = StringBuilder()
    val back = StringBuilder()
    repeat(TX - SX) {
        go.append("R")
        back.append("L")
    }
    repeat(TY - SY) {
        go.append("U")
        back.append("D")
    }
    println(go.toString() + back.toString() + "DR" + go.toString() + "UL" + "UL" + back.toString() + "DR")
}