package offer66;

import java.util.Stack;

public class Five {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int first=stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }

    public static void main(String[] args) {
        Five five = new Five();
        int[] nodeList = {1,2,3,4,5,6,34,12};
        //入队
        for (int i = 0; i < nodeList.length; i++) {
            five.push(nodeList[i]);
        }
        //出队
        for (int i = 0; i < nodeList.length; i++) {
            int result = five.pop();
            System.out.println(result);

        }
    }
}
