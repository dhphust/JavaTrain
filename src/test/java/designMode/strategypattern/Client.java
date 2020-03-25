package designMode.strategypattern;

public class Client {
    public static void main(String[] args) {
        //定义策略
        Strategy strategy = new ConcreteAStrategy();
        //使用策略
        Context context = new Context(strategy);
        context.algorithm();
    }
}
