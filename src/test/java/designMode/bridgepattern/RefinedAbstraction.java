package designMode.bridgepattern;

public class RefinedAbstraction extends Abstraction {

    @Override
    public void operaction() {
        implementor.operationImpl();
    }
}
