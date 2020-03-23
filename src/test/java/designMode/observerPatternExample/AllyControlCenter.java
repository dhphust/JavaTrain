package designMode.observerPatternExample;

import java.util.ArrayList;
import java.util.List;

/**
 * 战队控制中心：目标类
 */
public abstract class AllyControlCenter {

    protected String allyName; //战队名称
    protected List<Observer> players = new ArrayList<>();  //战队成员

//    public AllyControlCenter(String allyName) {
//        this.allyName = allyName;
//    }

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    /**
     * 注册方法
     * @param observer
     */
    public void join(Observer observer) {
        System.out.println(observer.getName() + "加入" + this.allyName + "战队");
        players.add(observer);
    }

    /**
     * 注销方法
     * @param observer
     */
    public void quit(Observer observer) {
        System.out.println(observer.getName() + "退出" + this.allyName + "战队");
        players.remove(observer);
    }

    /**
     * 通知观察者
     * @param name
     */
    public abstract void notifyObserver(String name);

}
