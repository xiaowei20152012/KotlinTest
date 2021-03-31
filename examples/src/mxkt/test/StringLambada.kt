package mxkt.test

fun main() {
    // 函数
    var method: (String, String) -> Unit = {str1, str2 -> println("a: $str1 b: $str2")}
//    method("hello", "world")

    var method2 = { println("Day")}
//    method2()
    var method3 : (String) -> Unit = {
        println("compiler $it")
    }
//    method3("hello")
    var method4: (Int) -> Unit = {
        when(it) {
            1 -> println("Hello $it")
            in 20..30 -> println("world $it")
            else -> println("not work")
        }
    }
//    method4(20)
    var method5: (Int, Int) -> Unit = { num1, num2 -> println("hello $num1 , $num2")}
    method5(5,6)

}