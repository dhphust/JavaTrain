package generics;

import java.util.ArrayList;
import java.util.List;

public interface Comparable<T> {
    void test(T t);
}

/**
 * 范型擦除
 */
class T1 implements Comparable{

    @Override
    public void test(Object o) {

    }
}

/**
 * 父类擦除，子类范型
 */
class T3<T> implements Comparable{

    @Override
    public void test(Object o) {

    }
}

/**
 *声明子类，指定具体类型
 */
class T2 implements Comparable<String>{
    @Override
    public void test(String s) {

    }
}
