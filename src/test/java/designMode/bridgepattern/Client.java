package designMode.bridgepattern;

public class Client {
    public static void main(String[] args) {
        //定义抽象类（维度1）
        Abstraction abstraction = new RefinedAbstraction();
        //设置具体类（维度2）
        abstraction.setImplementor(new ConcreteImplementorA());
        //维度1调用维度2方法
        abstraction.operaction();
    }
}
