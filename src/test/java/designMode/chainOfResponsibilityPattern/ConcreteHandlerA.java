package designMode.chainOfResponsibilityPattern;

public class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest() {
        boolean satisfyRequest = false;
        if (satisfyRequest) {
            System.out.println("ConcreteHandlerA请求满足条件，处理");
        } else {
            System.out.println("ConcreteHandlerA不满足条件，转发");
            this.successor.handleRequest();  //转发请求
        }
    }
}
