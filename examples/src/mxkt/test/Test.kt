package mxkt.test

fun main() {
    var method5 : (Int, Int) -> Unit = {num1, num2 -> println("hello $num1 , world $num2")}
    method5(4,5)
}

fun method2(str: Any) : String? {
    if (str is String) {
        return str.toUpperCase()
    }
    return null
}


fun method() : Unit {
    var array: IntArray = intArrayOf(1,2,3,4)
    for (item in array) {

    }

}