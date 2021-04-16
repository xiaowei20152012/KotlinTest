package mxkt.test.classes

// 如果primary构造方法没有注解或者可见性修饰符，constructor 关键字可以忽略
class EmptyClass

// 在kotlin中，一个类可以有一个primary构造方法以及一个或者多个secondary构造方法
//
// primary 构造方法， 是类头的一部分 class header， 可以拥有若干参数
class MyClass constructor(a : Int) {
    //初始化代码块 给类的变量初始值
    init {

    }
}

class MyClass1 constructor(a : Int) {
    // 也可以这样初始值
//    private val num : Int = a

    private var num : Int
    init {
        this.num = a
    }

    constructor(a : Int, b : String) : this(a) {
        this.num = a;
    }

}



