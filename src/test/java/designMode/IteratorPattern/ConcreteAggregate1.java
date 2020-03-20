package designMode.IteratorPattern;

/**
 * 将迭代器设计为聚合类的内部类
 */
public class ConcreteAggregate1 implements Aggregate {
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator();
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

    /**
     * 定义内部类迭代器：封装聚合对象的访问
     */
    public class ConcreteIterator implements Iterator {
        private int cursor;

        public ConcreteIterator() {
            cursor = aggregateSize();
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
            return aggregateItem();
        }
    }
}
