package mxjava.test.decorator;

/**
 * 装饰模式为了为已经有的功能动态添加更多的一种方式
 *
 * 装饰原来类的核心职责和主要行为
 *
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        BigTrouser big = new BigTrouser();
        TShirts ts = new TShirts();


        big.Decorate(person);
    }
}
