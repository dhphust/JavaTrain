package ConcurrentPro;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile导致的不一致性（即volatile不能保证原子性）
 * 计数实例
 * 开10个线程，每个线程进行10000次计数累加，正常情况下结果=100000
 * 但因为volatile不能保证原子性，当一个线程进行计数加到100时，另一个线程也开始计数，将上一个线程的100变为101，
 * 但此时第一个线程读到的还是100，计数后变为101，覆盖之前的101；（第一个线程先读，第二个线程后加+1操作）
 * 最终导致10个线程累加后的值小于100000
 * 为解决volatile问题，可以在计数函数中使用synchronized，
 * 但是使用synchronized，每次计数都要加锁操作，内存开销大
 * 解决办法：
 * （1）使用java自带的AtomicXXX原子操作类
 * （2）引入CAS机制，一种无锁机制，解决不一致性问题
 */
public class T8 {
    volatile int count = 0;
    public /*synchronized*/ void m1(){
        for (int i = 0; i < 10000; i++) {
             count ++;
        }
    }

    public static void main(String[] args) {
        T8 t8 = new T8();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(()->t8.m1()));
        }
        list.forEach((o)->o.start());
        list.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t8.count);
    }
}
