package designMode.adaptermode;

/**
 * 适配器
 */
public class Adapter extends Target {
    private Adaptee adaptee;

    public Adapter() {
       adaptee = new Adaptee();
    }

    @Override
    public void request() { //目标抽象类的同名方法
        adaptee.specificRequest(); //调用被适配角色的方法
    }
}
