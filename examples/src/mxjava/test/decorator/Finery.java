package mxjava.test.decorator;

/**
 * 服饰类 decorator
 */
public class Finery extends Person {

    protected Person component;

    public void Decorate(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        super.show();
    }
}
