package mxkt.test

import retrofit2.Retrofit

object HelloArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = Array(
            5
        ) { Array(4) { Array(5) { IntArray(6) } } }

        a[0][0][0];
    }
    fun test() {
        Retrofit.Builder().build();
    }
}