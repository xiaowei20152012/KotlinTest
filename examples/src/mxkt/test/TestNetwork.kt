package mxkt.test

import kotlin.concurrent.thread

fun main(args: Array<String>) {
    createThread()

}


fun createThread(): Unit {
    thread { run {
        println("current thread id")
    } }
}