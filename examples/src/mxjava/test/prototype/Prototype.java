package mxjava.test.prototype;

/**
 * 原型模式就是从一个对象创建另一个可定制的对象，不需要知道任何细节
 */
abstract class Prototype {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract Prototype Clone();
    // 关键方法
}
