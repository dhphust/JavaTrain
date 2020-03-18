package designMode.decoratormode;
/**
 * 具体装饰类
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedBehavior();  //调用新增业务方法
    }

    public void addedBehavior() {
        System.out.println("装饰B后的构件");
    }
}
