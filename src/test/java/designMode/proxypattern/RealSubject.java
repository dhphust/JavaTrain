package designMode.proxypattern;

/**
 * 目标主题类
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("我是目标对象");
    }
}
