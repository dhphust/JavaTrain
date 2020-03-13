package designMode.factory.abstractFactory;

public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
    void finish();
}
