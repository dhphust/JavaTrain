package offer66;

/**
 * 链表中倒数第K个节点
 */
public class A14 {
    public static ListNode1 FindKthToTail(ListNode1 head,int k) {
        ListNode1 pre=null,p=null;
        //两个指针都指向头结点
        p=head;
        pre=head;
        //记录k值
        int a=k;
        //记录节点的个数
        int count=0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while(p!=null){
            p=p.next;
            count++;
            if(k<1){
                pre=pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if(count<a) return null;
        return pre;
    }

    private static ListNode1 buildListNode(int[] input){
        ListNode1 first = null,last = null,newNode;
        if(input.length>0){
            for(int i=0;i<input.length;i++){
                newNode=new ListNode1(input[i]);
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
        int[] input = {2,3,4,6,7,3};
        ListNode1 node1 = buildListNode(input);
        ListNode1 result = FindKthToTail(node1,3);
        System.out.println(result.val);
    }
}
class ListNode1 {
    int val;
    ListNode1 next = null;

    ListNode1(int val) {
        this.val = val;
    }
}
