package designMode.observerPatternExample;

/**
 * 具体战队控制中心
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "组队成功");
        this.allyName = allyName;
    }

    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName + "战队紧急通知，盟友*" + name + "*遭受敌人攻击");
        //调用每一个盟友的支援方法
        for (Observer observer : players) {
            if (!(observer.getName().equalsIgnoreCase(name))) {
                observer.help();
            }
        }
    }
}
