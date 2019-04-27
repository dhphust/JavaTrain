package MultiThread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 并发容器比较
 * 开100个线程，每个线程往容器中添加1000个随机数
 * 比较不同的容器最终的执行时间
 *
 * hashtable将整个容器加锁操作，一次只有一个线程可以获取容器的锁对象
 * concurrentHashMap将容器分为16个段，每次操作仅对一个段加锁；如果两个线程操作的段不同，两个线程可以并发执行，分别锁不同的段
 * concurrentHashMap 1.8之后，不在使用segment分离锁，使用cas实现同步问题，底层是基于"数组+链表->红黑树"结构
 * ConcurrentSkipListMap 适用于高并发并排好序，插入数据因为要排序，所以比较耗时，但是查询效果好
 */
public class T19_ConcurrentMap {
    public static void main(String[] args) {

//    Map<String,String> map = new ConcurrentHashMap<>();//并发比较高的时候使用
    Map<String,String> map = new ConcurrentSkipListMap<>();//并发比较高且需要排序时使用
//        Map<String, String> map = new Hashtable<>();//使用频率很低
//    Map<String,String> map = new HashMap<>();
        Random random = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + random.nextInt(10000),"b" + random.nextInt(10000));
                }
                countDownLatch.countDown();
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
//        Arrays.asList(threads).forEach(t->t.start());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

}
