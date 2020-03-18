package designMode.decoratormode;

public class Client {
    public static void main(String[] args) {
        //定义具体构件
        Component component = new ConcreteComponent();
        //定义装饰后的构件
        Component decoratorComponent = new ConcreteDecoratorA(component);
        Component decoratorComponent1 = new ConcreteDecoratorB(decoratorComponent);
        decoratorComponent1.operation();
    }
}
