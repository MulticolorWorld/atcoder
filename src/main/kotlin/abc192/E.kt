package abc192

import java.util.*

fun main() {
    val (N, M, X, Y) = readLine()!!.split(" ").map { it.toInt() }

    val ev = Array(N+1){ mutableListOf<EInfo>() }
    repeat(M){
        val (a, b, t, k) = readLine()!!.split(" ").map { it.toInt() }
        ev[a].add(EInfo(b, t, k))
        ev[b].add(EInfo(a, t, k))
    }

    val d = Array(N+1){ Long.MAX_VALUE }
    val queue = PriorityQueue<Pair<Int, Long>>(compareBy { it.second })
    queue.add(Pair(X, 0))
    while (queue.isNotEmpty()){
        val (nowPlace, nowTime) = queue.poll()
        for (next in ev[nowPlace]) {
            val nextTime =
            if(nowTime % next.k == 0L){
                nowTime + next.cost
            }else{
                nowTime + (next.k - (nowTime % next.k)) + next.cost
            }
            if(d[next.to] > nextTime){
                d[next.to] = nextTime
                queue.add(Pair(next.to, nextTime))
            }
        }
    }

    if(d[Y] == Long.MAX_VALUE){
        println(-1)
    }else{
        println(d[Y])
    }
}

data class EInfo(
    val to: Int,
    val cost: Int,
    val k: Int
)