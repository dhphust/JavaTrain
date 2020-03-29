package designMode.CompositePattern;

public class Client {
    public static void main(String[] args) {
        Component leaf1, leaf2, leaf3, composite;

        leaf1 = new Leaf();
        leaf2 = new Leaf();
        leaf3 = new Leaf();

        composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);
        composite.add(leaf3);

        composite.operation();
    }
}
