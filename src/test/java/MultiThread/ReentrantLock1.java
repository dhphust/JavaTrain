package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * reentrantlock重入锁，用于替代synchronized
 * 本例由于m1锁定this，只有m1执行完毕，m2才能执行
 *复习synchronized的原始语义
 */
public class ReentrantLock1 {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    synchronized void m2(){
        System.out.println("m2");
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        new Thread(()->reentrantLock1.m1(),"thread1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->reentrantLock1.m2(),"thread2").start();
    }

}