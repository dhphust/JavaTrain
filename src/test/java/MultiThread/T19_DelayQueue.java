package MultiThread;

import javax.rmi.CORBA.Util;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 无界队列
 * 实现定时任务
 */
public class T19_DelayQueue {
    static BlockingQueue<MyTask> tasks = new DelayQueue();
    static Random random = new Random();
    static class MyTask implements Delayed{
        long runTime;

        public MyTask(long runTime) {
            this.runTime = runTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            return 0;

        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "runTime=" + runTime +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask(now + 1000);
        MyTask t2 = new MyTask(now + 1500);
        MyTask t3 = new MyTask(now + 2000);
        MyTask t4 = new MyTask(now + 2500);
        MyTask t5 = new MyTask(now + 3000);
        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);
        System.out.println(tasks);
        for (int i = 0; i < 5; i++) {
            System.out.println(tasks.take());
        }
    }
}
