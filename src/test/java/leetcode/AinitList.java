package leetcode;

/**
 * 初始化一个链表的流程
 */
public class AinitList {

    public void solution(ListNode head){
        System.out.println(head.val);
    }


    static ListNode head = null;
    static ListNode tem = null;
    public void addNode(int d) {
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
        AinitList ainitList = new AinitList();
        int[] a = {1, 2, 3};
        for (int i = 0; i < 3; i++) {
            ainitList.addNode(a[i]);
        }
        ListNode l1 = head;
        ainitList.solution(l1);
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
