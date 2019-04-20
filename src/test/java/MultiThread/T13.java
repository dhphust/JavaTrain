package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 改进T12的死循环问题
 * 使用wait和notify,wait会释放锁，notify不会释放锁
 * 运用这种方式，必须保证thread2先运行，也就是让thread2先进入监听状态
 * 运行结果thread2 end在最后打印出来，没有在size==5时打印出来，原因？
 * thread1 size=5时，notify会唤醒thread2，但是notify因为不会释放锁，
 * 导致即使唤醒thread2，但因为thread2拿不到lock锁对象，所以无法继续执行
 */
public class T13 {
    volatile List<Integer> list = new ArrayList<>();

    public void add(Integer integer){
        list.add(integer);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        T13 t13 = new T13();
        final Object lock = new Object();

        //开启thread2
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("thread2 begin");
                if (t13.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread2 end");
            }
        }, "thread2").start();

        //休眠1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开启thread1
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("thread1 begin");
                for (int i = 0; i < 10; i++) {
                    t13.add(i);
                    System.out.println("add" + i);
                    //达到条件时，唤醒线程
                    if (t13.size() == 5) {
                        lock.notify();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, "thread1").start();

    }
}
