package leetcode.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 回溯法实现电话号码字母组合
 */
public class LetterCombinations {
     List<String> result = new ArrayList<>();
     Map<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0)
           backtrack(digits.toCharArray(),0,"");
        return result;
    }

    private void backtrack(char[] chars, int i, String res) {
        if(i == chars.length){
            result.add(res);
            return;
        }
        String letters = map.get(chars[i]);//获取数字对应英文组合
        for (int j = 0; j < letters.length(); j++) {
            String letter = letters.substring(j,j+1);
            backtrack(chars,i+1,res + letter);
        }


    }
    public static void main(String[] args) {
        LetterCombinations res = new LetterCombinations();
        System.out.println(res.letterCombinations("23"));

    }
}
