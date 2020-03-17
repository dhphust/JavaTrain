package designMode.adaptermodeExample;

/**
 * 缺省适配器方法：借助abstract类，避免了adapter适配器必须实现接口的所有方法的问题
 */
abstract public class AbstractService implements ServiceTarget {
    @Override
    abstract public void serviceMethod1();

    @Override
    public void serviceMethod2() {
        System.out.println("common method2");
    }

    @Override
    public void serviceMethod3() {
        System.out.println("common method3");
    }
}
