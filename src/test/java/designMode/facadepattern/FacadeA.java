package designMode.facadepattern;

/**
 * 外部包装类
 */
public class FacadeA {
    private static FacadeA instance;

    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    private FacadeA() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    public static FacadeA getInstance() {
        if (instance == null) {
            synchronized (FacadeA.class) {
                if (instance == null) {
                    instance = new FacadeA();
                }
            }
        }
        return instance;
    }

    public void method() {
        subsystemA.method();
        subsystemB.method();
        subsystemC.method();
    }
}
