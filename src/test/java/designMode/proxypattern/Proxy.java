package designMode.proxypattern;

/**
 * 代理类
 */
public class Proxy implements Subject {
    //引用目标对象
    private RealSubject realSubject;

    public Proxy() {
        realSubject = new RealSubject();
    }

    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问目标对象前进行。。。");
    }

    public void postRequest() {
        System.out.println("访问目标对象后进行。。。");
    }
}
