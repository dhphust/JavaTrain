package designMode.observerPatternExample;

/**
 * 抽象观察类
 */
public interface Observer {
    String getName();
    void setName(String name);

    /**
     * 声明支援盟友的方法
     */
    void help();

    /**
     * 玩家遭受袭击
     * @param allyControlCenter
     */
    void beAttacked(AllyControlCenter allyControlCenter);
}
