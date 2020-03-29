package designMode.CompositePatternExample;

public class HRDepartment implements AbstractDepartment {
    @Override
    public void notice(String companyName) {
        System.out.println(companyName + "HR Department notice");
    }
}
