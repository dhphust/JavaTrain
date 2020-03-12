package designMode.factory.factoryMethod;

/**
 * productA的生产工厂
 */
public class ProductAFactory implements Factory {

    @Override
    public Product getProduct() {
        return new ProductA();
    }
}
