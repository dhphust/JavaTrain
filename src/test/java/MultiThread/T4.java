package MultiThread;
import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请时仍会得到该对象的锁
 *也就说synchronized获得的锁是可重入的
 */
public class T4 {
    public synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }

    public synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 start");
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.m1();
    }
}
