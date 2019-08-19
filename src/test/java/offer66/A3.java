package offer66;

import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList;
//输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
public class A3 {
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
    static class ListNode
    {
        int val;
        ListNode next;
        public ListNode(int x){
            val=x;
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
    public static void main(String[] args)
    {
        int[] input=new int[]{1,2,3,3,4,4,5};
        ListNode listNode=buildListNode(input);
        ArrayList<Integer> list = printListFromTailToHead(listNode);
        Iterator it1 = list.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
    }

}

