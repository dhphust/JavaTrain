package designMode.IteratorPattern;

/**
 * 聚合对象
 */
public interface Aggregate {
    Iterator createIterator();
    String aggregateItem();
    int aggregateSize();
}
