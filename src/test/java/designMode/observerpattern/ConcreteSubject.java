package designMode.observerpattern;

/**
 * 具体目标类：具体被观察对象
 */
public class ConcreteSubject extends Subject {
    /**
     * 通知观察者
     */
    @Override
    public void notice() {
        //调用观察者的响应方法
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
