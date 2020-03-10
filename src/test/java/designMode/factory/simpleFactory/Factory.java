package designMode.factory.simpleFactory;

public class Factory {
    /**
     * 创建不同的产品
     * @param name
     * @return
     */
    public static Product getProduct(String name){
        Product product = null;
        if(name.equalsIgnoreCase("A")){
            product = new ProductA();
        }else if(name.equalsIgnoreCase("B")){
            product = new ProductB();
        }
        return product;
    }

    public static void main(String[] args) {
        String name = "A";
        Product product = Factory.getProduct(name);
        product.commonMethod();
        product.diffMtehod();
    }
}
