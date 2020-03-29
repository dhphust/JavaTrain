package designMode.CompositePattern;

/**
 * 抽象构件类
 */
public abstract class Component {
    public abstract void operation();   //业务方法
    public void add(Component component){   //添加成员

    }
    public void remove(Component component){    //删除成员

    }
    public Component getChild(int i){ //获取成员
        return  null;
    }
}
