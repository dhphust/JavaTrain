package MultiThread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 并发队列
 */
public class T19_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.offer("a" + i);//添加元素到队列
        }
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.poll());//拿出队首元素，并在队列中删除
        System.out.println(queue.size());
        System.out.println(queue.peek());//拿出队首元素，但在队列中不删除
        System.out.println(queue.size());

    }
}
