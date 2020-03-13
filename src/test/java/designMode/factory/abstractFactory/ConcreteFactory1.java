package designMode.factory.abstractFactory;

/**
 *海尔产品生产厂
 */
public class ConcreteFactory1 implements AbstractFactory {
    /**
     * 海尔电视机
     * @return
     */
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    /**
     * 海尔冰箱
     * @return
     */
    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }

    @Override
    public void finish() {
        System.out.println("海尔设备生产完成");
    }
}
