package ConcurrentPro;

import java.util.concurrent.TimeUnit;

/**
 * 子类调用父类的同步方法
 * 锁定的同一个对象：父类的对象
 */
public class T5 {

    public synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");
    }

    public static void main(String[] args) {
        new TT5().m1();
    }
}

class TT5 extends T5{
    public synchronized void m1(){
        System.out.println("child start");
        super.m1();
        System.out.println("child end");
    }
}
