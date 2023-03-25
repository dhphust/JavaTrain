package MultiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author duhaipeng
 * @date 2023-03-25
 *
 * 说明：SecondBatchWorker等待FirstBatchWorker任务执行完毕，再执行
 */
public class T19_CountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(latch));
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(latch));
            t.start();
        }
//        // 注意这里也是演示目的的逻辑，并不是推荐的协调方式
//        while ( latch.getCount() != 1 ){
//            Thread.sleep(100L);
//        }
        System.out.println("Wait for first batch finish");
        latch.countDown();
    }

    static class FirstBatchWorker implements Runnable {
        private CountDownLatch latch;
        public FirstBatchWorker(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            System.out.println("First batch executed!");
            latch.countDown();
        }
    }

    static class SecondBatchWorker implements Runnable {
        private CountDownLatch latch;
        public SecondBatchWorker(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            try {
                latch.await();
                System.out.println("Second batch executed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
