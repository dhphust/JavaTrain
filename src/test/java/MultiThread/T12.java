package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，提供两个方法：add,size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现容器元素个数的监听，当个数达到5个时，线程2给出提示并结束
 * 考点：volatile，不加volatile，thread1添加值后，thread2拿不到通知，导致无法正确计数
 * thread2的死循环，浪费cpu，改进？
 */
public class T12 {
    volatile List list = new ArrayList();

//    public <T extends Number> void add(T o){
//        list.add(o);
//    }
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        T12 t12 = new T12();
        //first thread add element
       new Thread(()->{
           for (int i = 0; i < 10; i++) {
               t12.add(i);
               System.out.println("add " + i);
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       },"thread1").start();

       //second thread
        new Thread(()->{
           while(true){
               if(t12.size() == 5){
                   break;
               }
           }
            System.out.println("T2 end");
        },"thread2").start();
    }
}
