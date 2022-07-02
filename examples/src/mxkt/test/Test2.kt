package mxkt.test

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//    GlobalScope.launch {
//        delay(1000)
//        val s = " world"
//        print("hello $s")
//    }
//    println("end")
////    Thread.sleep(2000)
//    runBlocking {
//        delay(2000)
//    }
    val ids: List<String> = listOf("1","2","3")
    val response: String = ids.joinToString(",")

    println(response)
}