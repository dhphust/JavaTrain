package designMode.chainOfResponsibilityPatternExample;

/**
 * 董事长类
 */
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            System.out.println("董事长处理请求:" + request);
        } else {
            //转发处理请求
            this.successor.processRequest(request);
        }

    }
}
