package abc192

fun main() {
    val S = readLine()!!
    var f = true
    for (i in S.indices) {
        if(i % 2 == 0){
            if(S[i].toString() != S[i].toString().toLowerCase()){
                f = false
                break
            }
        }else{
            if(S[i].toString() == S[i].toString().toLowerCase()){
                f = false
                break
            }
        }
    }
    if (f) println("Yes") else println("No")
}