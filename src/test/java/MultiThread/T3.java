package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * 银行账户实际应用
 * 对业务写加锁
 * 对业务读不加锁
 * 容易产生脏读
 */
public class T3 {
    String name;
    double balance;

    //读不加锁
    //加锁时，执行这个方法之前首先要获得这个对象，
    //因为set方法已经获得了锁，处于休眠状态，但没有释放资源，所以该方法要等待set方法
    public /*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    //写加锁
    public synchronized void set(String name, double balance){
        this.name = name;
        //休眠2s，其他不加锁程序可能会执行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;

    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        new Thread(()->t3.set("xiaoli",300),"thread1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //休眠1s后执行，此时set方法还在休眠中，还拿不到最新的300
        System.out.println(t3.getBalance("xiaoli"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t3.getBalance("xiaoli"));

    }
}
