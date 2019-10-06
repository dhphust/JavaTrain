package offer66;

import java.util.Stack;

/**
 * 包含main函数的指针
 * 获取栈中最小元素的方法
 * 应用一个辅助栈，压的时候，如果 A 栈的压入比 B 栈压入大，B 栈不压，，，，小于等于，
 * AB 栈同时压入，出栈，如果，AB 栈顶元素不等，A 出，B 不出。
 */
public class A20 {

    Stack<Integer> stack = new Stack();
    Stack<Integer> temp = new Stack();

    public void push(int node) {
        stack.push(node);
        if(temp.empty())
            temp.push(node);
        else if(node <= temp.peek())
            temp.push(node);
    }
    public void pop() {
        if(stack.peek() == temp.peek())
            temp.pop();
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int min() {
        return temp.peek();
    }
    public static void main(String[] args) {
        A20 a20 = new A20();
        a20.push(8);
        a20.push(5);
        a20.push(4);
        a20.push(6);
        System.out.println(a20.min());
    }
}

//    Stack<Integer> stack = new Stack<Integer>();
//
//    public void push(int node) {
//        stack.push(node);
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        int min = top();
//        int tmp = 0;
//        Iterator<Integer> iterator = stack.iterator();
//        while (iterator.hasNext()){
//            tmp = iterator.next();
//            if (tmp<min){
//                min = tmp;
//            }
//        }
//        return min;