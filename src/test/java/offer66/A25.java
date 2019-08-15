package offer66;

public class A25 {

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    private static RandomListNode buildListNode(int[] input){
        RandomListNode first = null,last = null,newNode;
        if(input.length>0){
            for(int i=0;i<input.length;i++){
                newNode=new RandomListNode(input[i]);
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
        RandomListNode node1 = buildListNode(input);
        RandomListNode result = Clone(node1);
        System.out.println(result.label);
    }
}
