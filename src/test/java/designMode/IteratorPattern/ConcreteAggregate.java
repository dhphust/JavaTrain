package designMode.IteratorPattern;

/**
 * 具体聚合对象
 */
public class ConcreteAggregate implements Aggregate {

    @Override
    public Iterator createIterator() {
       return new ConcreteIterator(this);
    }

    /**
     * 聚合对象的元素
     * @return
     */
    public String aggregateItem() {
        return "aggregate item";
    }

    /**
     * 聚合对象的数量
     * @return
     */
    public int aggregateSize() {
        return 5;
    }

}
