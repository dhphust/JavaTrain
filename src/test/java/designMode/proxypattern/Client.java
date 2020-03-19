package designMode.proxypattern;

public class Client {
    public static void main(String[] args) {
        //传统调用
        Subject subject = new RealSubject();
        subject.request();

        System.out.println("引入代理模式");
        //现在想访问目标对象前，进行。。。
        Subject subject1 = new Proxy();
        subject1.request();
    }
}
