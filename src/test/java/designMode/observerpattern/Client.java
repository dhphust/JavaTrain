package designMode.observerpattern;

public class Client {
    public static void main(String[] args) {
        //定义观察目标对象
        Subject subject = new ConcreteSubject();
        //定义观察者对象
        Observer observer1 = new ConcreteObserver("tom");
        Observer observer2 = new ConcreteObserver("jack");
        //添加观察者对象
        subject.attach(observer1);
        subject.attach(observer2);
        //当观察目标发生变化，通知观察者
        //。。。。
        subject.notice();

    }
}
