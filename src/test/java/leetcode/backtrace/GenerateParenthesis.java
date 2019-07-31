package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定整数n，生成有效的括号组合
 * 回溯法：在已知序列保持有效的前提下添加"（" 或者"）"
 */
public class GenerateParenthesis {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrace(n,0,0,"");
        return result;
    }

    private void backtrace(int n, int left, int right, String res) {
        if(res.length() == 2 * n){
            result.add(res);
            return;
        }
        if(left < n){ //至少还能添加一个左括号
            backtrace(n,left + 1,right, res + "(");
        }
        if(right < left) { //右括号的个数小于左括号的个数，可添加一个右括号
            backtrace(n,left,right + 1, res + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println(result);
    }
}
