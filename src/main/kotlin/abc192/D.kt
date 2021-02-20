package abc192

import java.math.BigInteger
import kotlin.system.exitProcess

fun main() {
    val X = readLine()!!
    val M = readLine()!!.toLong()

    val maxX = X.toCharArray().sortedArray().last().toString().toInt()
    if(X.length == 1){
        if(X.toLong() <= M){
            println(1)
        } else {
            println(0)
        }
        exitProcess(0)
    }

    val xRev = X.reversed()
    var l = maxX.toLong()
    var r = M * 2
    while (r - l > 1){
        val m = l + (r - l) / 2
        var x = BigInteger.ZERO
        for(j in xRev.indices){
            x += BigInteger(m.toString()).pow(j) * BigInteger(xRev[j].toString())
        }
        if(x <= BigInteger(M.toString())){
            l = m
        }else{
            r = m
        }
    }
    println(l-maxX)
}

