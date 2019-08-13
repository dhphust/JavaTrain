package offer66;

/**
 * 合并两个排序的链表
 */
public class A16 {
    public static ListNode Merge(ListNode head1,ListNode head2) {
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode root=head;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                head.next=head1;
                head = head1;
                head1 = head1.next;
            }else{
                head.next=head2;
                head = head2;
                head2 = head2.next;
            }
        }
        if(head1 != null){
            head.next = head1;
        }
        if(head2 != null){
            head.next = head2;
        }
        return root.next;
    }
    //构建链表
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
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int[] input1 = {2,5,8,9};
        int[] input2 = {3,5,6,7,10};
        ListNode head1 = buildListNode(input1);
        ListNode head2 = buildListNode(input2);
        ListNode result = Merge(head1,head2);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
