package designMode.facadepattern;

/**
 * 外部包装类
 */
public class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    /**
     * 封装子类的方法调用
     */
    public void method() {
        subsystemA.method();
        subsystemB.method();
        subsystemC.method();
    }
}
