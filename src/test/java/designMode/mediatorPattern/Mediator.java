package designMode.mediatorPattern;

import java.util.ArrayList;

/**
 * 抽象中介者
 */
public abstract class Mediator {
    private ArrayList<Colleague> colleagues;    //存储同事对象

    /**
     * 注册方法，增加对象
     * @param colleague
     */
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }
    public abstract void operation();
}
