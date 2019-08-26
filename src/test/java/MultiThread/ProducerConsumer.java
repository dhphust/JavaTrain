package MultiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者模型
 * 通过BlockQueue实现
 * 当一个线程对已经满了的阻塞队列进行入队操作时会阻塞，
 * 除非有另外一个线程进行了出队操作，当一个线程对一个空的阻塞队列进行出队操作时也会阻塞，除非有另外一个线程进行了入队操作。
 */
public class ProducerConsumer {
    private static int count = 0;
    //创建一个阻塞队列
    final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Producer()).start();
        new Thread(producerConsumer.new Consumer()).start();


    }

    //生产者-生产数据
    class Producer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    count++;
                    blockingQueue.put(count);//生产数据放入阻塞队列
                    System.out.println(Thread.currentThread().getName()+ "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
            //消费
            while (true){
                try {
                    blockingQueue.take();//从队列中移除一个元素，若队列为空，阻塞
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
