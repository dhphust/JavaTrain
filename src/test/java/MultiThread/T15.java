package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * T15 wait()\notify()方式过于繁琐
 * 使用Latch(门闩)替代wait、notify进行通知
 * 优势：通信方式简单，可以设置等待时间
 * 使用await和countdown替代wait、notify
 * CountDownLatch不涉及锁定，当count的值为0当前线程继续执行
 * 当不涉及到同步，只是线程通信的话，使用synchronized+wait+notify方式显得太重
 * 这是应该考虑countdownlatch/cyclicbarrier/semaphore
 *
 * 门闩latch使用原理：初始化一个门闩countDownLatch，并赋初值；
 * 开两个线程，当thread1执行到一定程度时，使用await方法休眠thread1；
 * thread2开始执行，当thread2执行到一定程度，想唤醒thread1时，使用countDown方法进行countDownLatch减一操作；
 * 当countDownLatch=0时，thread1线程被唤醒，继续执行
 */
public class T15 {
    volatile List list = new ArrayList();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        T15 t15 = new T15();
        //定义一个门闩，值为1；当值=0时，门闩解开
        CountDownLatch countDownLatch = new CountDownLatch(1);

        //开启thread2
        new Thread(() -> {
                System.out.println("thread2 begin");
                if (t15.size() != 5) {
                    try {
                        countDownLatch.await();//休眠，释放资源
                        //可以指定等待时间
                   //     countDownLatch.await(1000,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread2 end");
        }, "thread2").start();

        //休眠1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开启thread1
        new Thread(()->{
            System.out.println("thread1 begin");
            for (int i = 0; i < 10; i++) {
                t15.add(i);
                System.out.println("add " + i);
                if(t15.size() == 5){
                    //打开门闩，让thread2继续执行
                    //countdown使门闩值减1
                    countDownLatch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1").start();

    }

}
