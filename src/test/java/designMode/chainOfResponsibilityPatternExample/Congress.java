package designMode.chainOfResponsibilityPatternExample;

/**
 * 董事会类
 */
public class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("董事会商量购买:" + request);
    }
}
