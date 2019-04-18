package ConcurrentPro;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字，使一个变量在多个线程间可见
 * 假设存在两个线程A，B，A，B都用到同一个变量，
 * java默认是A线程中保留一份副本，如果B修改了变量，A线程未必知道
 * 使用volatile关键字，可以让多个线程每次都读到最新的值
 * 代码解读：
 * 当线程t7开始运行的时候，会把running值从内存中读到t1线程的工作区，
 * 在运行过程中直接使用这个副本，并不会每次都去读堆内存(running存在堆内存的t7对象中)，这样，当主内存
 * 修改running的值后，t1线程感知不到，所以不会停止运行
 * 使用volatile，将会强制要求所有线程去堆内存中读取running的值
 * volatile不能保证原子性，无法替代synchronized
 */
public class T7 {
    /*volatile*/ boolean running = true;
    void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        new Thread(()->t7.m()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t7.running = false;

    }

}
