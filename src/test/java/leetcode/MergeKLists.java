package leetcode;

/**
 * 合并k个链表
 * 二路归并
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return resolve(lists,0,lists.length-1);
    }

    //归并排序
    private ListNode resolve(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        int mid = (left + right) >> 1;
        ListNode leftNode = resolve(lists, left, mid);
        ListNode rightNode = resolve(lists, mid + 1, right);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode) {
        if(leftNode == null)
            return rightNode;
        if(rightNode == null)
            return leftNode;

        if(leftNode.val < rightNode.val){
            leftNode.next = merge(leftNode.next, rightNode);
            return leftNode;
        } else {
          rightNode.next = merge(leftNode, rightNode.next);
          return rightNode;
        }

    }


    public static void main(String[] args) {

    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
