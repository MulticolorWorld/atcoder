package abc45

import java.util.*

fun main(args: Array<String>) {
    val SA = ArrayDeque(readLine()!!.toList())
    val SB = ArrayDeque(readLine()!!.toList())
    val SC = ArrayDeque(readLine()!!.toList())
    SA.add('e')
    SB.add('e')
    SC.add('e')

    var turn = 'a'
    while (SA.isNotEmpty() && SB.isNotEmpty() && SC.isNotEmpty()) {
        turn = when (turn) {
            'a' -> SA.poll()
            'b' -> SB.poll()
            'c' -> SC.poll()
            else -> throw Error()
        }
        if (turn == 'e') {
            when {
                SA.isEmpty() -> 'A'
                SB.isEmpty() -> 'B'
                SC.isEmpty() -> 'C'
                else -> throw Error()
            }.let { println(it) }
            return
        }
    }
}