package leetcode;

import java.util.Stack;

public class IsValid {

    public static boolean isValid(String s){
        if(s == null)
            return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '[')
                stack.push(chars[i]);
            if(stack.isEmpty())
                return false;
            if(chars[i] == ')' || chars[i] == '}' || chars[i] == ']')
            {
                char temp = stack.pop();
                if(chars[i] == ')' && temp == '(')
                    continue;
                if(chars[i] == '}' && temp == '{')
                    continue;
                if(chars[i] == ']' && temp == '[')
                    continue;
                return false; //无法匹配
            }
        }
        //全部比较完毕
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "{[]}";
        System.out.println(isValid(str));
    }
}
