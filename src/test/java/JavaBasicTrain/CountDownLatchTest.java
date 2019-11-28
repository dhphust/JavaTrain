package JavaBasicTrain;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 多语言翻译
 * extend Thread:主线程无法捕获子线程的异常，可以借助UncaughtExceptionHandler实现
 * implements Runable:直接在子线程try-catch，解决父线程无法捕获子线程问题
 * https://www.cnblogs.com/yangfanexp/p/7594557.html
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(3);

        TranslateThread thread1 = new TranslateThread("1st content",count);
        TranslateThread thread2 = new TranslateThread("2nd content",count);
        TranslateThread thread3 = new TranslateThread("3rd content",count);
        thread1.run();
        thread2.run();
        thread3.run();

        try {
            count.await(10,TimeUnit.SECONDS); //等待子线程10s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程全部完毕");
    }
}

class TranslateThread implements Runnable{
    private String content;
    private final CountDownLatch count;

    public TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        //翻译解释，抛出异常测试
        try{
            if(Math.random() > 0.5){
                throw new RuntimeException();
            }
            System.out.println(content + "翻译完成");
        }catch (Exception e){
            System.out.println(content + "原文存在非法字符");
        }finally {
            count.countDown();
        }
    }
}
