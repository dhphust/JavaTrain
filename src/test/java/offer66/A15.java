package offer66;

/**
 * 反转链表
 */
public class A15 {
    public static ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        ListNode preNode = null;
        ListNode nextNode = null;
        while(head != null){
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            nextNode = head.next;
            //保存完next，就可以让head从指向next变成指向pre
            head.next = preNode;

            preNode = head;
            head = nextNode;
        }
        return preNode;

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
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int[] input = {2,3,4,6,7,3};
        ListNode node1 = buildListNode(input);
        ListNode result = ReverseList(node1);
        while(result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }

}

