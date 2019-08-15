package offer66;

import java.util.Scanner;

/**
 * 初始化链表
 */
public class A {

    public static void solution(ListNode head){
        System.out.println(head.val);
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
        int[] input = {2,3,4,6,7,3};
//        Scanner input = new Scanner(System.in);
//        int N = input.nextInt();//输入N个数
//        int[] array = new int[N];
//        for (int i = 0; i < N; i++) {
//            array[i] = input.nextInt();
//        }
        ListNode node1 = buildListNode(input);
        solution(node1);
    }
}
