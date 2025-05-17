package data_structures_algorithms.katas

fun  main() {
val str = "krishna"
val n: Int = str.length
val newStr = reverseString(str, n)
println(newStr)
}

fun reverseString(str: String, n:Int): String {

var newStr: StringBuilder = StringBuilder()

    for(i in n-1 downTo 0) {
        newStr.append(str[i].toString())

    }

    return newStr.toString()

}