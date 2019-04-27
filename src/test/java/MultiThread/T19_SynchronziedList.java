package MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * synchronizedList实现：给不加锁的list加锁
 */
public class T19_SynchronziedList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> listSyn = Collections.synchronizedList(list);

    }
}
