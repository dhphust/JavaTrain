package designMode.CompositePatternExample;

public class RDDepartment implements AbstractDepartment {
    @Override
    public void notice(String companyName) {
        System.out.println(companyName + "RD Department notice");
    }
}
