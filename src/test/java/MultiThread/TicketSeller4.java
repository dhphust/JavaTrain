package MultiThread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 使用jdk5之后提供的并发容器queue
 */
public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedDeque<>();
    static {
        for (int i = 0; i < 100; i++) {
             tickets.add("票编号： "+ i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while(true){
                    String s = tickets.poll();
                    if(s == null)break;
                    else
                        System.out.println(Thread.currentThread().getName() + "销售了："+ s);
                }
            }).start();
        }
    }
}
