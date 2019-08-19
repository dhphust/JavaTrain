package offer66;

/**
 * 两个链表的第一个公共节点
 */
public class A36 {

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = findListLength(pHead1);
        int len2 = findListLength(pHead2);
        if(len1 > len2){
            pHead1 = walkStep(pHead1, len1-len2);
        }else{
            pHead2 = walkStep(pHead2, len2-len1);
        }
        while(pHead1 != null){
            if(pHead1.val == pHead2.val)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
    static int findListLength(ListNode pHead){
        int len = 0;
        while(pHead != null){
            pHead = pHead.next;
            len++;
        }
        return len;

    }
    static ListNode walkStep(ListNode pHead, int step){
        while(step > 0){
            pHead = pHead.next;
            step--;
        }
        return pHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    private static ListNode buildListNode(int[] input){
        ListNode first = null,last = null,newNode;
        if(input.length>0 ){
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

        int[] input1 = {2,3,23,45,4,6};
        ListNode node1 = buildListNode(input1);
        int[] input2 = {4,6};
        ListNode node2 = buildListNode(input2);
        ListNode result = FindFirstCommonNode(node1,node2);
        System.out.println(result.val);
    }
}
