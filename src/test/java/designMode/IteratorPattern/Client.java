package designMode.IteratorPattern;

public class Client {
    public static void main(String[] args) {
        //创建聚合对象
        Aggregate aggregate = new ConcreteAggregate();
        //创建迭代器对象
        Iterator iterator = aggregate.createIterator();

        //迭代器：在不需了解聚合类内部结构情况下，对聚合对象成员遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
