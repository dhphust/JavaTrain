package ZuoAlgorithm;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 *
 */
public class A2 {
    Stack<Integer> stack1 = new Stack<>();//作为压入栈
    Stack<Integer> stack2 = new Stack<>();//作为弹出栈

    public void add(int val){
        stack1.push(val);
    }

    /**
     * 将stack1压入stack2，弹出stack2栈顶
     * @return
     */
    public int poll(){
        int value = -1;
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            value = stack2.pop();
            //返回到stack1中
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return value;
    }

    public int peek(){
        int value = -1;
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            value = stack2.peek();
            //返回到stack1中
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return value;
    }

    public static void main(String[] args) {
        A2 a2 = new A2();
        int[] array = {3,4,5,2,3,4};
        for (int i = 0; i < array.length; i++) {
            a2.add(array[i]);
        }
        System.out.println(a2.poll());
        System.out.println(a2.peek());
    }
}
