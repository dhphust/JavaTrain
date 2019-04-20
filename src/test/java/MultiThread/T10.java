package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某对象o，如果o的属性发生变化，不影响锁的使用
 * 但是如果o变成了另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变为另外的对象
 */
public class T10 {
    Object o = new Object();
    public void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T10 t10 = new T10();
        //第一个线程
        new Thread(()->t10.m()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //第二个线程
        Thread t2 = new Thread(()->t10.m());
        t10.o = new Object();//锁对象发生改变，所以t2线程得以实现，如果注释掉这句话，t2永远得不到执行的机会
        t2.start();

    }
}
