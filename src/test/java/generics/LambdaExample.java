package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * lambda实现一本书是否在list中
 */
public class LambdaExample {
    public static void main(String[] args) {
        List<String> bookList = new ArrayList<>();
        bookList.add("c++");
        bookList.add("java");
        bookList.add("scala");
        compareStrings(bookList,(n)->n.contains("java"));
    }
    public static void compareStrings(List<String> list, Predicate<String> predicate) {
        list.stream().filter((n) -> (predicate.test(n))).forEach((n) -> {
            System.out.println(n + " ");
        });
    }
}
