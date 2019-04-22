package MultiThread;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * 生产者-消费者模式
 * 写一个固定容量同步容器，拥有put和get方法
 * 能够支持2个生产者线程和10个消费者线程的阻塞调用
 * 使用lock/condition/await/signalall实现
 * condition的方式可以更加精确的指定哪些线程被唤醒
 **/

public class T18<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();
    private final int MAX = 10;
    private int count = 10;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void producer(T t){
        try {
            lock.lock();
            while (linkedList.size() == MAX)
            {
                producer.await();
            }
            linkedList.add(t);//生产
            count++;
            consumer.signalAll();//通知消费者线程消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T consumer(){
        T t = null;
        try {
            lock.lock();
            while (linkedList.size() == 0){
                consumer.await();
            }
            t = linkedList.removeFirst();//消费
            count--;
            producer.signalAll();//唤醒生产者生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        T18<String> t17 = new T18();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(t17.consumer());
                }
            },"consumer" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    t17.producer(Thread.currentThread().getName() +" "+j);
                }
            },"producer" + i).start();
        }
    }

}
