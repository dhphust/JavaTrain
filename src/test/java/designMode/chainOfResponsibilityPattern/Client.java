package designMode.chainOfResponsibilityPattern;

public class Client {
    public static void main(String[] args) {
        //建立责任链
        Handler concreteHandlerA = new ConcreteHandlerA();
        Handler concreteHandlerB = new ConcreteHandlerB();
        concreteHandlerA.setSuccessor(concreteHandlerB);

        //开始处理请求
        concreteHandlerA.handleRequest();
    }
}
