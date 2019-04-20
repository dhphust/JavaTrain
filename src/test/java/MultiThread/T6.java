package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * 程序在执行过程中，如果出现异常，默认情况锁会被释放
 * 所以，在并发处理的过程中，有异常一定要小心，不然可能会发生不一致现象；
 * 比如，在一个web app处理过程中，多个servlet线程共同访问一个资源，
 * 如果异常处理不合适，在其中一个线程中抛出异常，因锁会被释放，其他线程会进入同步代码块，
 * 可能会读到异常产生的数据
 */
public class T6 {
    int count = 0;
    public synchronized void m(){
        System.out.println(Thread.currentThread().getName()+ " start");
        while (true){//定义成死循环，如果第一个线程不释放锁，会一直执行这个循环
            count++;
            System.out.println(Thread.currentThread().getName() + " count=" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 5){
                    int i = count/0;//此处抛出异常，锁将被释放
                }
//            try {
//                if(count == 5){
//                    int i = count/0;//此处抛出异常，锁将被释放
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        }
    }
    public static void main(String[] args) {
        T6 t6 = new T6();
        for (int i = 0; i < 2; i++) {
            new Thread(()->t6.m(),"thread"+i).start();

        }
    }
}
