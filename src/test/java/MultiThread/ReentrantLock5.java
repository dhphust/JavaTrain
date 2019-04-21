package MultiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentrantlock指定公平锁
 * synchronized非公平锁（一个线程释放锁后，随机选择另一个线程获取锁对象），但是效率高；
 * reentrantlock指定公平锁(一个线程释放锁后，等待时间长的线程获得优先获得锁对象)，效率低
 */
public class ReentrantLock5 extends Thread {
    private static ReentrantLock lock= new ReentrantLock(true);
    public void m1(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 reentrantLock5 = new ReentrantLock5();
        new Thread(()->reentrantLock5.m1(),"thread1").start();
        new Thread(()->reentrantLock5.m1(),"thread2").start();
        new Thread(()->reentrantLock5.m1(),"thread3").start();
    }
}
