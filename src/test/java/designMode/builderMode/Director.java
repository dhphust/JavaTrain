package designMode.builderMode;

/**
 * 负责复杂对象的创建过程
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    //产品构建和组装方法
    public Product construct() {
        builder.buildPartA();;
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
