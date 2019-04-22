package MultiThread;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 使用vector实现线程同步，保证remove、size原子性
 * 虽然remove、size都具有原子性，但不能保证他们中间的执行具有原子性
 * 比如一个线程中间休眠10秒钟，另外的线程会继续执行remove操作
 * 当remove操作使得容器为0时，第一个线程唤醒后继续执行remove，使得容器=-1
 */
public class TicketSeller2 {
    static Vector<String> ticketLists = new Vector<>();
    static {
        for (int i = 0; i < 100; i++) {
             ticketLists.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (ticketLists.size() > 0) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName() + " 销售了" + ticketLists.remove(0));
                }
            }).start();
        }
    }
}
