package offer66;

/**
 * 链表中环的入口节点
 */
public class A55 {

     static ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        //定义两个指针，扫描链表
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p1 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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

    public static void main(String[] args) {
        int[] input = {2,3,4,5,6,3,4};
        ListNode root = buildListNode(input);
        ListNode result = EntryNodeOfLoop(root);
        System.out.println(result.val);

    }
}
