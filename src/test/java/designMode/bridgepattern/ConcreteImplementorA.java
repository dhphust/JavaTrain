package designMode.bridgepattern;

/**
 * 具体实现类（维度2）
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorA");
    }
}
