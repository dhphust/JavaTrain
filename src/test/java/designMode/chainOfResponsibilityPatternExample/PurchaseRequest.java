package designMode.chainOfResponsibilityPatternExample;

/**
 * 购买商品类
 */
public class PurchaseRequest {
    private String purpose;   //采购物品名称
    private Integer number;  //采购数量
    private Double amount;  //采购金额

    public PurchaseRequest(String purpose, Integer number, Double amount) {
        this.purpose = purpose;
        this.number = number;
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "purpose='" + purpose + '\'' +
                ", number=" + number +
                ", amount=" + amount +
                '}';
    }
}
