package designMode.chainOfResponsibilityPattern;

public class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest() {
        System.out.println("ConcreteHandlerB满足条件，处理请求");
    }
}
