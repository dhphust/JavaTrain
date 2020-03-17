package designMode.adaptermodeExample;

public class Client {
    public static void main(String[] args) {
        ServiceTarget target = new ServiceAdapter();
        target.serviceMethod1();
        target.serviceMethod2();
        target.serviceMethod3();
    }
}
