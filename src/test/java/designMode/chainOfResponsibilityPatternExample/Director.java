package designMode.chainOfResponsibilityPatternExample;

/**
 * 主管类
 */
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 10000) {
            System.out.println("主管处理请求:" + request);
        } else {
            //转发处理请求
            this.successor.processRequest(request);
            //this.setSuccessor(new President(name));
        }

    }
}
