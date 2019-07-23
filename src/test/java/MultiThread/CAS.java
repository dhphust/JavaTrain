package MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger使用
 */
public class CAS {
    private static AtomicInteger count = new AtomicInteger(5);
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = count.decrementAndGet();
                if(left < 1){
                    System.out.println(Thread.currentThread().getName() + "没抢到");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "抢了一件商品");
                System.out.println("还剩" + left);
            }).start();

        }
    }
}
