package com.test.one

class Invoker(val handler: Handler): Callback {
    fun invoke(num: Int) {
        Thread(Runnable { handler.handlerData(this, num) }).start()
    }
    override fun accept(any: Any) {

    }
}