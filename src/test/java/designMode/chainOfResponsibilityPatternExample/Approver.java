package designMode.chainOfResponsibilityPatternExample;

/**
 * 审批类
 */
public abstract class Approver {
    protected Approver successor; //定义后继审批
    protected String name;     //审批人

    public Approver(String name) {
        this.name = name;
    }

    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    /**
     * 审批请求
     * @param request
     */
    public abstract void processRequest(PurchaseRequest request);
}
