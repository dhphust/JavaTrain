package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 利用线程池并行计算1～20000之间的所有质数
 */
public class T20_ParallelComputing {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //单线程计算
        long start = System.currentTimeMillis();
        List<Integer> result = getPrime(1,20000);
        long end = System.currentTimeMillis();
        System.out.println("one thread time:" + (end-start));

        //开启线程池多线程计算
        final int threadNum = 3;
        ExecutorService service = Executors.newFixedThreadPool(threadNum);

        Mytask t1 = new Mytask(1,8000);
        Mytask t2 = new Mytask(8001,12000);
        Mytask t3 = new Mytask(12001,20000);

        Future<List<Integer>> f1= service.submit(t1);//提交任务，submit会调用callable
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);

        start = System.currentTimeMillis();
        f1.get(); //等待，直到任务执行完毕，拿到返回值
        f2.get();
        f3.get();
   //     System.out.println(f3.get());
        end = System.currentTimeMillis();
        System.out.println("muti thread time:" + (end-start));
        service.shutdown();
    }

    static class Mytask implements Callable<List<Integer>> {
        int start = 0;
        int end = 0;

        public Mytask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(start,end);
            return r;
        }
    }

    private static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isPrime(i))
                results.add(i);
        }
        return results;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
