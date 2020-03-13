package designMode.factory.abstractFactory;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory;
        AbstractProductA productA;
        AbstractProductB productB;

        //海尔工厂生产中。。。
        factory = new ConcreteFactory1();
        productA = factory.createProductA();
        productB = factory.createProductB();
        productA.display();
        productB.display();
        factory.finish();

        //TCL工厂生产中。。。
        factory = new ConcreteFactory2();
        productA = factory.createProductA();
        productB = factory.createProductB();
        productA.display();
        productB.display();
        factory.finish();
    }
}
