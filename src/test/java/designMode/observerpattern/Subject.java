package designMode.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标类:被观察对象
 */
public abstract class Subject {
    //定义一个观察者集合，存储所有的观察者对象
    protected List<Observer> observers = new ArrayList<>();

    /**
     * 注册方法，向观察者集合中添加一个观察者
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 注销方法，从观察者集合中删除一个观察者
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     */
    public abstract void notice();
}
