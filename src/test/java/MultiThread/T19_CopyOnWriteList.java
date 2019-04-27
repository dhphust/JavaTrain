package MultiThread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制容器
 * 多线程环境下，写的效率低，但是读的效率高，适合写少读多的情况
 * 当向容器中写入一个数据时，首先把原容器中的数据复制一份，然后在复制后的容器中加入新的数据
 * 因为每次新数据都不在原容器中，所以读数据时不需要加锁；但是因为每次要复制原容器内容，所以写入时间长
 */
public class T19_CopyOnWriteList {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();//并发时会出现问题
//        List<String> list1 = Collections.synchronizedList(list);
        List<String> list = new Vector<>();
//        List<String> list = new CopyOnWriteArrayList<>();

        Random random = new Random();
        Thread[] threads = new Thread[100];

//        for (int i = 0; i < threads.length; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 0; j < 1000; j++) {
//                        list.add("a" + random.nextInt(10000));
//                    }
//                }
//            };
//            threads[i] = new Thread(runnable);
//        }

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    list.add("a" + random.nextInt());
                }
            });
        }

        runTimeCompare(threads);
        System.out.println(list.size());

    }

    private static void runTimeCompare(Thread[] threads) {
        long time1 = System.currentTimeMillis();
        Arrays.asList(threads).forEach(t->t.start());
        Arrays.asList(threads).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }

}
