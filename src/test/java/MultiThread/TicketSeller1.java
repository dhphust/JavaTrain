package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 有N张火车票，每张票有一个唯一编号
 * 有10个窗口同时在售票
 * 请写一个模拟程序
 * 问题：重复售票
 * 原因：remove不具有原子性
 */
public class TicketSeller1 {
    static List<Integer> ticketLists = new ArrayList<>();
    static {
        for (int i = 0; i < 100; i++) {
             ticketLists.add(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    while (ticketLists.size() > 0) {
                        System.out.println(Thread.currentThread().getName() + "销售了-----" + ticketLists.remove(0));
                    }
                }).start();
        }
    }
}
