package MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 调用lockInterruptibly方法，可以对线程interrupt方法做出响应
 * 在一个线程等待锁的时候，可以被打断
 */
public class ReentrantLock4 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        //thread1一直占用着锁
        Thread thread1 = new Thread(()->{
            lock.lock();
            System.out.println("t1 start");
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }finally {
                lock.unlock();
            }
        });
        thread1.start();

        //打断thread2，避免苦等thread1
        Thread thread2 = new Thread(()->{
            try {
//                lock.lock();
                lock.lockInterruptibly();//执行thread2打断响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }finally {
                if(lock.tryLock()){
                    lock.unlock();
                }
            }
        });
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.interrupt();//打断thread2的等待

    }

}
