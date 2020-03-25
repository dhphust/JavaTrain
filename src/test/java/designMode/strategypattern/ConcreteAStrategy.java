package designMode.strategypattern;

public class ConcreteAStrategy implements Strategy {
    @Override
    public void algorithn() {
        System.out.println("算法A");
    }
}
