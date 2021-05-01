package mxjava.test.operationfactory;

public final class OperationFactory {

    public static void main(String[] args) {
        createOperate("+");
    }


    public static Operation createOperate(String type) {
        Operation operation = null;
        switch (type) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
