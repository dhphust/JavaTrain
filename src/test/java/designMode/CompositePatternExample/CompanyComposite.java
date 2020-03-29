package designMode.CompositePatternExample;

import java.util.ArrayList;
import java.util.List;

public class CompanyComposite implements AbstractDepartment {
    private List<AbstractDepartment> list = new ArrayList<>();

    @Override
    public void notice(String name) {
        //递归各部门
        for (AbstractDepartment abstractDepartment : list) {
            abstractDepartment.notice(name);
        }
    }

    @Override
    public void addDepatment(AbstractDepartment department) {
        list.add(department);
    }

    @Override
    public void delDepatment(AbstractDepartment department) {
        list.remove(department);
    }

    @Override
    public AbstractDepartment getChild(int i) {
        return list.get(i);
    }
}
