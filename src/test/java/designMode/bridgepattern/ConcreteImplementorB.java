package designMode.bridgepattern;

/**
 * 具体实现类（维度2）
 */
public class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorB");
    }
}
