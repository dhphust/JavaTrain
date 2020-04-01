package designMode.mediatorPattern;

/**
 * 抽象同事类
 */
public abstract class Colleague {
    protected Mediator mediator; //抽象中介者引用

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 声明自身方法，处理自己的行为
     */
    public abstract void method();

    /**
     * 定义依赖方法，与中介者通信
     */
    public void operation() {
        mediator.operation();
    }
}
