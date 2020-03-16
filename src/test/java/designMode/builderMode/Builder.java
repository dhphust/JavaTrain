package designMode.builderMode;

/**
 * 抽象建造类，里面包含了所有的属性信息、方法；
 */
public abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    //返回建造好的产品对象
    public Product getResult(){
        return product;
    }
}

