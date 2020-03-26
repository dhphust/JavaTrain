package designMode.chainOfResponsibilityPattern;

/**
 * 抽象处理类
 */
public abstract class Handler {
    protected Handler successor; //定义后继审批

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest();
}
