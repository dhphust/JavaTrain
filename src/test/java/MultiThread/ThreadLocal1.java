package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * threadLocal线程局部变量
 */
public class ThreadLocal1 {

    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        },"thread1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "tom";
        },"thread2").start();
    }
}

class Person{
    String name = "java";

}
