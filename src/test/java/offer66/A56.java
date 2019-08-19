package offer66;

/**
 * 删除链表中重复的节点
 */
public class A56 {

    public static ListNode deleteDuplication(ListNode pHead) {

        ListNode first = new ListNode(-1);//设置一个trick
        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;//记录重复节点的最后一个位置
        while (p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p!= null&&p.val == val)
                    p = p.next;
                last.next = p;//last指向重复节点的最后一个位置
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }

    private static ListNode buildListNode(int[] input){
        ListNode first = null,last = null,newNode;
        if(input.length>0){
            for(int i=0;i<input.length;i++){
                newNode=new ListNode(input[i]);
                newNode.next=null;
                if(first==null){
                    first=newNode;
                    last=newNode;
                }
                else{
                    last.next=newNode;
                    last=newNode;
                }

            }
        }
        return first;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,3,4,5,6};
        ListNode root = buildListNode(input);
        ListNode head = deleteDuplication(root);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
