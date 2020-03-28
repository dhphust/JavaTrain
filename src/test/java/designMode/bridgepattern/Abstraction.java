package designMode.bridgepattern;

/**
 * 抽象类（维度1）
 */
public abstract class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operaction();
}
