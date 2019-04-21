package MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentrantLock可以进行尝试锁定"tryLock"，这样无法锁定、或者在指定时间内无法锁定，线程可以决定是否继续等待
 */
public class ReentrantLock3 {
    Lock lock = new ReentrantLock();

    /**
     * m1()不变
     */
    void m1() {
        System.out.println("thread1");
        lock.lock();//等价于synchronized this
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 使用trylock进行尝试锁定，不管锁定与否，方法都将继续执行
     * 可以根据trylock的返回值判断是否锁定
     * 也可以指定trylock的时间，由于trylock(time)抛出异常，所以要注意unlock的处理，必须放到finally
     */
    void m2() {
        System.out.println("thread2");
        boolean locked = false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);//尝试等待5s中，看是否能获得锁对象
            if (locked) {
                System.out.println("获得锁啦,thread2执行骚操作吧");
            }
            System.out.println("m2....." + locked);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 reentrantLock3 = new ReentrantLock3();
        new Thread(() -> reentrantLock3.m1()).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> reentrantLock3.m2()).start();
    }
}
