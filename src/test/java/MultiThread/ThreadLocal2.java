package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 *线程局部变量，一个线程拿不到另一个线程设定的变量值
 *threadLocal好处在于空间换时间；synchronzied在于时间换空间
 */
public class ThreadLocal2 {
    static ThreadLocal<Person1> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());//该线程拿不到另一个线程设置的变量值
        },"thread1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           threadLocal.set(new Person1());
            System.out.println(threadLocal.get().name);
        },"thread2").start();
    }

}

class Person1{
    String name = "tom";
}