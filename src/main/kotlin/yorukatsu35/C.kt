package yorukatsu35

fun main(args: Array<String>) {
    val s = readLine()!!
    val list = mutableListOf<String>()
    for (i in s.indices) {
        if (s[i] == 'B') {
            if (list.isNotEmpty()) {
                list.removeAt(list.size - 1)
            }
        } else if (s[i] == '0') {
            list.add("0")
        } else if (s[i] == '1') {
            list.add("1")
        }
    }
    println(list.toTypedArray().joinToString(separator = ""))
}