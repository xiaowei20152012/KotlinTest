package mxjava.test.strategy;

/**
 * 策略模式
 * 用来封装算法，可以用来封装任何的类型规则
 *
 * 策略模式用来定义一种一系列算法，所有算法完成相同的工作，实现不同而已
 */
public class Test {
    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrategy());
        context.ContextInterface();

        context = new Context(new ConcreteStrategyB());
        context.ContextInterface();


    }
}
