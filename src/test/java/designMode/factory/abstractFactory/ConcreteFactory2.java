package designMode.factory.abstractFactory;

/**
 * TCl产品工厂
 */
public class ConcreteFactory2 implements AbstractFactory {
    /**
     * TCL电视机
     * @return
     */
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    /**
     * TCL冰箱
     * @return
     */
    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }

    @Override
    public void finish() {
        System.out.println("TCL产品生产完毕");
    }
}
