package MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock完成上一个实例同样的功能
 * 需要注意的是：需要手动释放锁
 * synchronized手动上锁，自动释放；reentrantLock手动上锁，手动释放
 * synchronized锁定的对象遇到异常时，jvm会自动释放锁；但是Lock必须手动释放锁，因此经常在finally中进行锁的释放
 */
public class ReentrantLock2 {
    Lock lock = new ReentrantLock();

    void m1(){
        lock.lock();//等价于synchronized this
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        System.out.println("m2");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock2 reentrantLock2 = new ReentrantLock2();
        new Thread(()->reentrantLock2.m1()).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->reentrantLock2.m2()).start();
    }

}
