package designMode.CompositePattern;

/**
 * 叶子构件
 */
public class Leaf extends Component{

    @Override
    public void operation() {
        System.out.println("执行叶子方法");
    }
}
