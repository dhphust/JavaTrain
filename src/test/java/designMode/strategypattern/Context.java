package designMode.strategypattern;

/**
 * 环境类：使用策略的角色
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用策略中的算法
     */
    public void algorithm() {
        strategy.algorithn();
    }
}
