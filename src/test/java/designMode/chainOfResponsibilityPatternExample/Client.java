package designMode.chainOfResponsibilityPatternExample;

public class Client {
    public static void main(String[] args) {
        //建立职责链
        Approver director1 = new Director("director1");
        Approver president1 = new President("president1");
        Approver congress1 = new Congress("congress1");
        director1.setSuccessor(president1);
        president1.setSuccessor(congress1);

        //建立采购单
        PurchaseRequest request = new PurchaseRequest("桌子",20, 1000.5);
        director1.processRequest(request);

        PurchaseRequest request1 = new PurchaseRequest("桌子",20, 500000.5);
        director1.processRequest(request1);

    }
}
