package leetcode;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * 输出链表中倒数第N个节点
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); //解决删除head情况时，head节点删不掉问题,在head前补一个dumny
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i = 1; i <= n + 1; i++) {
            p1 = p1.next;
        }
        while(p1 != null && p2 != null){
            p1 =p1.next;
            p2 =p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
    static ListNode head = null;
    static ListNode tem = null;
    public static void addNode(int d) {
        ListNode N = new ListNode(d);
        if (head == null) {
            head = N;
            return;
        }
        tem = head;
        while (tem.next != null) {
            tem = tem.next;
        }
        tem.next = N;
    }


    public static void main(String[] args) {
        int[] a = {2, 4, 9, 8, 5, 3};
        for (int i = 0; i < 2; i++) {
            addNode(a[i]);
        }
        ListNode p1 = head;//已经建立好链表
        ListNode result = removeNthFromEnd(p1,2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

  }
