package MultiThread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 生产者-消费者模式
 * 写一个固定容量同步容器，拥有put和get方法
 * 能够支持2个生产者线程和10个消费者线程的阻塞调用
 * 使用synchronzied wait/notifyall实现
 * 使用while而不是if原因：
 * 首先，put方法中当list size = 10时，等待
 * 当size < 10时，线程被唤醒，代码从 this.wait()后继续执行；
 * 如果使用if，当执行到add方法时，如果其他线程已经进行了add，此时再进行add依次，可能会超出容器的容量限制（10）；
 * 而使用while，线程被唤醒后，先进行容器的容量大小判断，再add
 * wait 99%的情况要跟while一起使用
 */
public class T17<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();
    private final int MAX = 10;
    int count = 0;
    synchronized void producer(T t){
        while (linkedList.size() == MAX){//此处为何用while，而不是if
            try {
                this.wait();//wait会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.add(t);
        count++;
        //通知消费者线程进行消费
        this.notifyAll();//为何不使用notify？notify只是唤醒一个线程，唤醒的可能又是一个生产者，
        // 如果生产者唤醒后继续执行put方法，执行到wait时等待，那整个程序就停住了
    }
    synchronized T consumer(){
        T t = null;
        while (linkedList.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = linkedList.removeFirst();//消费
        count--;
        this.notifyAll();//通知生产者生产
        return t;
    }

    public static void main(String[] args) {
        T17<String> t17 = new T17();
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
