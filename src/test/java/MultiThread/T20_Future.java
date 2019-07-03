package MultiThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * future异步获取计算结果
 */
public class T20_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(5);
            return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());  //等待，直到任务执行完成，拿到返回结果

        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(()->{
            TimeUnit.SECONDS.sleep(5);
            return 1;
        });

     //   System.out.println(f.get());
        System.out.println(f.isDone()); //如果任务完成，返回true
        System.out.println(f.get());  //等待，直到任务执行完成，拿到返回结果
        System.out.println(f.isDone());
        service.shutdown();
    }
}
