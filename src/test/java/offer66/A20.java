package offer66;

import java.util.Iterator;
import java.util.Stack;

/**
 * 包含main函数的指针
 * 获取栈中最小元素的方法
 */
public class A20 {
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = top();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (tmp<min){
                min = tmp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        A20 a20 = new A20();
        a20.push(3);
        a20.push(5);
        a20.push(4);
        a20.push(2);
        System.out.println(a20.min());
    }
}
