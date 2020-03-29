package designMode.CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器构件
 */
public class Composite extends Component {
    private List<Component> list = new ArrayList<>();

    /**
     * 容器构件具体业务方法
     */
    @Override
    public void operation() {
        //递归调用成员构件的业务方法
        for (Component component : list) {
            component.operation();
        }
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return list.get(i);
    }
}
