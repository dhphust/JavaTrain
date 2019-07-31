package leetcode;

/**
 * 合并两个链表为1个
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode prev = node;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
//        while(l1 != null){
//            node.next = l1;
//            node = node.next;
//            l1 = l1.next;
//        }
//        while(l2 != null) {
//            node.next = l2;
//            node = node.next;
//            l2 = l2.next;
//        }
        node.next = (l1 == null ? l2 : l1);
        return prev.next;
    }

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
