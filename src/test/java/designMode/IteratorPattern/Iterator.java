package designMode.IteratorPattern;

/**
 * 迭代器
 */
public interface Iterator {
    void first();
    void next();
    boolean hasNext();
    String currentItem();

}
