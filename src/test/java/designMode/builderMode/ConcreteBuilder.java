package designMode.builderMode;

/**
 * 具体建造类，实现抽象建造类定义的方法，并返回一个建造好的对象
 */
public class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
        product.setPathA("build pathA");

    }

    @Override
    public void buildPartB() {
        product.setPathB("build pathB");
    }

    @Override
    public void buildPartC() {
        product.setPathC("build pathC");
    }
}
