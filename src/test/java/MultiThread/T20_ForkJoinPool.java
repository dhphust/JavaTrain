package MultiThread;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * forkJoinPool，将大任务分为若干个小任务，小任务计算完成后，进行join合并
 */
public class T20_ForkJoinPool {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random random = new Random();

    //普通方法，进行计数统计
    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        System.out.println("sum= " + Arrays.stream(nums).sum());
    }

    //forkJoinPool，分而治之

    //    static class AddTask extends RecursiveAction {
//        int start;
//        int end;
//
//        public AddTask(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        protected void compute() {
//            if (end-start <= MAX_NUM){
//                int sum = 0;
//                for (int i = start; i < end; i++) {
//                     sum += nums[i];
//                }
//                System.out.println("form " + start + " to " + end + " sum= " + sum);
//            } else {//任务一分为二,交给两个子线程去执行
//                int middle = start + (end-start)/2;
//                AddTask addTask1 = new AddTask(start,middle);
//                AddTask addTask2 = new AddTask(middle+1,end);
//                addTask1.fork(); //开启子线程1
//                addTask2.fork(); //开启子线程2
//            }
//        }
//    }
    static class AddTask extends RecursiveTask<Long> { //RecursiveTask相对于RecursiveAction，可以达到返回值
        int start;
        int end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            }
            int middle = start + (end - start) / 2;
            AddTask addTask1 = new AddTask(start, middle);
            AddTask addTask2 = new AddTask(middle + 1, end);
            addTask1.fork(); //开启子线程1
            addTask2.fork(); //开启子线程2
            return addTask1.join() + addTask2.join();
        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        forkJoinPool.execute(task);
        long result = task.join(); //合并子任务结果
        System.out.println(result);

    //    System.in.read(); //因为ForkJoinPool是daemon线程，为了可以看到执行结果，此处进行阻塞

    }
}
