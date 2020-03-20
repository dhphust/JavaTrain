package designMode.IteratorPattern;

/**
 * 具体迭代器：封装具体聚合对象的访问
 */
public class ConcreteIterator implements Iterator {
    private ConcreteAggregate concreteAggregate;
    private int cursor;  //定义一个游标，记录当前访问位置

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
        this.cursor = concreteAggregate.aggregateSize();
    }

    @Override
    public void first() {
        if(cursor == 5) {
            System.out.println("first");
        }else {
            System.out.println("not first");
        }
    }

    @Override
    public void next() {
        cursor--;
    }

    @Override
    public boolean hasNext() {
        if (cursor != 0) {
            return true;
        } else {
            System.out.println("end");
            return false;
        }
    }

    @Override
    public String currentItem() {
        return concreteAggregate.aggregateItem();
    }
}
