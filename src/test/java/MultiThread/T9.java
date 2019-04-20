package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用java自带的原子操作类，解决数据不一致问题
 * 但是原子操作类不能保证多个方法连续调用时是原子性的
 */
public class T9 {
    AtomicInteger count = new AtomicInteger(0);
     public void m1(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T9 t9 = new T9();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(t9::m1));
        }
        list.forEach((o)->o.start());
        list.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t9.count);
    }

}
