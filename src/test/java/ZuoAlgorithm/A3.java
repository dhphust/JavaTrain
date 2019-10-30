package ZuoAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 递归逆序栈
 */
public class A3 {
    //将栈stack的栈底元素返回并移除
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);//除栈底之外的元素压入栈
            return last;
        }
    }
    //逆序输出栈
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        //获取栈底元素
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(4);
        reverse(stack);
        for (Integer result : stack) {
            System.out.print(result + " ");
        }
    }
}
