package designMode.builderMode;

public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);

        //构建产品
        Product product = director.construct();
        System.out.println(product);
    }
}
