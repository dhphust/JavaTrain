package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程线程池，保证任务的顺序性
 */
public class T20_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(()->{
                System.out.println(j + " " + Thread.currentThread().getName());
            });

        }
        service.shutdown();
    }
}
