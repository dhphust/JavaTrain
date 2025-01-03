package ZuoAlgorithm;


import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 定义一个辅助栈，始终保持栈顶元素最小
 */
public class A1 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();//保持栈顶最小

    /**
     * stack1正常入栈
     * stack2当栈顶元素大于新的入栈元素时，入栈
     * @param val
     */
    public void push(int val){
        stack1.push(val);
        if(stack2.isEmpty() || stack2.peek() > val){
            stack2.push(val);
        }
    }

    /**
     * stack1正常出栈
     * 如果stack2栈顶元素等于stack1，出栈
     * stack2始终保持栈顶比栈底小
     * @return
     */
    public int pop(){
        int value = stack1.pop();
        if(stack2.peek() == value){//判断辅助栈是否需要弹出
            stack2.pop();
        }
        return value;
    }
    public int min(){
        return stack2.peek();
    }

    public static void main(String[] args) {
        A1 a1 = new A1();
        int[] array = {3,6,4,3,2,8};
        for (int i = 0; i < array.length; i++) {
            a1.push(array[i]);
        }
        //出栈一次
        a1.pop();
        a1.pop();
        //打印最小值
        System.out.println(a1.min());
    }
}
