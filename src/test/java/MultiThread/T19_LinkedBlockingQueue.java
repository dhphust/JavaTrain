package MultiThread;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * queue分为：concurrentQueue和blockingQueue和DelayQueue
 * concurrentQueue为并发加锁式队列
 * blockingQueue为阻塞式队列，又分为：
 * LinkedBlockingQueue和ArrayBlockingQueue
 * DelayQueue实现定时任务
 * 阻塞式队列实现生产者-消费者模式
 */
public class T19_LinkedBlockingQueue {
    static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
    static Random random = new Random();

    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    blockingQueue.put("a" + i);//生产数据,队列满了，生产者阻塞
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"producer").start();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for(;;){
                    try {
                        System.out.println(Thread.currentThread().getName() + " take-" + blockingQueue.take());//消费数据，队列空了，消费者阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"consumer" + i).start();
        }
    }
}
