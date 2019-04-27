package MultiThread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue无边界队列
 * ArrayBlockingQueue是有边界队列,声明时必须指定容量
 */
public class T19_ArrayBlockingQueue {
    static ArrayBlockingQueue<String> strArrayBQ = new ArrayBlockingQueue<>(10);
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strArrayBQ.put("a" + i);
        }
//        strArrayBQ.put("aaaa");//队列满了，put方法再添加一个元素，会造成队列阻塞
//        strArrayBQ.add("aaa");//队列满了，会报异常
        boolean status = strArrayBQ.offer("aaaa");//如果队列满了，不再添加，返回一个bool值
        System.out.println(status);
//        strArrayBQ.offer("aa",1,TimeUnit.SECONDS);
    }


}
