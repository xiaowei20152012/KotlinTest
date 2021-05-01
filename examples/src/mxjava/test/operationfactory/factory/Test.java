package mxjava.test.operationfactory.factory;

import mxjava.test.operationfactory.Operation;

/**
 * 工厂模式
 *
 * 工厂的构建也是依赖接口
 *
 */
public class Test {
    public static void main(String[] args) {
        IFactory operateFactory = new AddFactory();
        Operation operation = operateFactory.CreateOperation();

    }
}
