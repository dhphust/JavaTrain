package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 改进T13 thread2拿不到锁，无法在size=5时，打印提示信息的问题
 */
public class T14 {
    volatile List list = new ArrayList();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        T14 t14 = new T14();
        final Object lock = new Object();

        new Thread(()->{
            synchronized (lock){
                System.out.println("thread2 begin");
                if(t14.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread2 end");
                lock.notify();//thread2执行完毕，唤醒thread1继续执行
            }
        },"thread2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (lock){
                System.out.println("thread1 begin");
                for (int i = 0; i < 10; i++) {
                    t14.add(i);
                    System.out.println("add " + i);
                    if(t14.size() == 5){
                        lock.notify();//唤醒当前休眠的thread1,因notify不释放锁，所以需要wait方法，使thread2休眠，释放锁给thread1
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread1 end");
            }
        },"thread1").start();
    }
}
