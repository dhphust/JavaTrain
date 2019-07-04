package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *无限线程池，适用于执行很多的短期异步任务的程序。
 * （CachedThreadPool的maxinumPoolSize被设置为Integer.MAX_VALUE
 */
public class T20_CachePool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);
        for (int i = 0; i < 5; i++) {
            service.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        TimeUnit.SECONDS.sleep(20);
        System.out.println(service);
        service.shutdown();
    }
}
