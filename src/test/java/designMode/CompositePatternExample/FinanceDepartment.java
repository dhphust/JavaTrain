package designMode.CompositePatternExample;

public class FinanceDepartment implements AbstractDepartment {
    @Override
    public void notice(String companyName) {
        System.out.println( companyName + "Finance Department notice");
    }
}
