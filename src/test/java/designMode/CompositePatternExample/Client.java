package designMode.CompositePatternExample;

public class Client {

    public static void main(String[] args) {
        //部门
        AbstractDepartment financeDept = new FinanceDepartment();
        AbstractDepartment hrDept = new HRDepartment();
        AbstractDepartment RDDept = new RDDepartment();

        //公司
        AbstractDepartment companyComposite = new CompanyComposite();
        //添加部门
        companyComposite.addDepatment(financeDept);
        companyComposite.addDepatment(hrDept);
        companyComposite.addDepatment(RDDept);

        //发送通知
        companyComposite.notice("上海");
    }
}
