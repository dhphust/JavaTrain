package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者模型
 * 通过wait、notify实现
 * 缓冲区满和为空时都调用wait()方法等待，当生产者生产了一个产品或者消费者消费了一个产品之后会唤醒所有线程。
 */
public class ProducerConsumer1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;//缓冲区大小
    private static String LOCK = "lock";
    public static void main(String[] args) {
        ProducerConsumer1 producerConsumer = new ProducerConsumer1();
        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Consumer()).start();

    }

    //生产者-生产数据
    class Producer implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (LOCK){
                    while (count == FULL) {//如果缓冲区已满
                        try {
                            LOCK.wait();//生产者等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;//生产一个数据
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();//生产完毕，唤醒消费者
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者-消费数据
    class Consumer implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (LOCK){
                    while (count == 0) {//如果缓冲区为空
                        try {
                            LOCK.wait();//消费者等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;//消费一个数据
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();//消费完毕，唤醒生产者
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
