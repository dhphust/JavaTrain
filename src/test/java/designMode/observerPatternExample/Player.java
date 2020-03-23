package designMode.observerPatternExample;

/**
 * 战队成员类：具体观察者类
 */
public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println(name + "坚持住，盟军马上到来");
    }

    /**
     * 当遭受攻击时，调用战控中心的通知方法，通知盟友
     * @param allyControlCenter
     */
    @Override
    public void beAttacked(AllyControlCenter allyControlCenter) {
        allyControlCenter.notifyObserver(name);
    }
}
