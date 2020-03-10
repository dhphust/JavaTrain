package designMode.factory.simpleFactory;

abstract public class Product {
    /**
     * 公共方法
     */
    public void commonMethod(){
        System.out.println("公共方法");
    }

    /**
     * 抽象业务方法
     */
    public abstract void diffMtehod();
}
