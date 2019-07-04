package MultiThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPool，定时任务
 * 每隔2秒钟执行一次command
 */
public class T20_ScheduledPool {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("开始周期性执行任务喽！！");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleAtFixedRate(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },0,2,TimeUnit.SECONDS);

  //  service.shutdown();
    }
}
