package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 使用synchronzied锁定票对象
 */
public class TicketSeller3 {
    static List<Integer> ticketLists = new ArrayList<>();

    static {
        for (int i = 0; i < 100; i++) {
            ticketLists.add(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (ticketLists) {
                        if (ticketLists.size() <= 0) break;
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "销售了-----" + ticketLists.remove(0));
                    }
                }

            }).start();
        }

    }
}
