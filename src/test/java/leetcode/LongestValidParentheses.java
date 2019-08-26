package leetcode;

import java.util.Stack;

/**
 * 最长匹配串
 * 利用栈，将字符数组下标存入栈
 * 如果是"（"，将数组下标入栈；如果是"）"，出栈一次，然后计算与栈顶下标的差值
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(-1);
        int i = 0;
        int max_length = 0;
        while(!stack.isEmpty() && i < chars.length){
            if(chars[i] == ')' && stack.peek() != -1){
                stack.pop();
                int temp_length = i - stack.peek();
                if(max_length < temp_length)
                    max_length = temp_length;
            }else {
                stack.push(i);
            }

            i++;
        }
//        if(chars[0] == '(')
//            return max_length + 1;
        return max_length;
    }

    public static int longestValidParentheses1(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses1(s));

    }
}
