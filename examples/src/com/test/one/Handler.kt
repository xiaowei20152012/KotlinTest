package com.test.one

class Handler {
    fun handlerData(callback: Callback, num: Int) {
        callback.accept(num.plus(1))
    }
}