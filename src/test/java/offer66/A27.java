package offer66;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的所有排列
 * 回溯法
 */
public class A27 {

    static List<String> list = new ArrayList<>();
    public static void backtrace(char[] str, int i, String res){
        if(i == str.length){ //i已经到达字符串末尾
            list.add(res);
            return;
        }
        for (int j = i; j < str.length; j++) { //从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串
            swap(str, i, j);//a、b、c分别与a交换
            backtrace(str, i + 1,res + String.valueOf(str[i]));//回溯，上次结果res + 本次加入的字符
            swap(str, i, j);//a位置不动，b、c分别与b交换
        }
    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "abc";
        backtrace(str.toCharArray(),0,"");
        System.out.println(list);
    }

}
