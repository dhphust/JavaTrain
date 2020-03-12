package designMode.factory.factoryMethod;

/**
 * productB的生产工厂
 */
public class ProductBFactory implements Factory {
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
