package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的所有排序（回溯法）
 */
public class PrintAllPermutations {
    static List<String> list = new ArrayList<>();
    public static void backtrace(char[] str, int i, String res){
        if(i == str.length){
            list.add(res);
            return;
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            backtrace(str, i + 1,res + String.valueOf(str[i]));//回溯，上次结果res + 本次加入的字符
            swap(str, i, j);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void resolution(String str){
        backtrace(str.toCharArray(),0,"");
    }

    public static void main(String[] args) {
        String str = "abc";
        resolution(str);
        System.out.println(list);
    }

//    /**
//     * 打印字符串的所有子序列（回溯法）
//     */
//    public class GenerateParenthesis {
//        static List<String> list = new ArrayList<>();
//        public static void backtrace(char[] str, int i, String res){
//            if(i == str.length){
//                list.add(res);
//                return;
//            }
//            backtrace(str,i+1,res);//回溯，不要本次的字符
//            backtrace(str,i+1,res + String.valueOf(str[i]));//回溯，上次结果res + 本次加入的字符
//        }
//        public static void solution(String str){
//            backtrace(str.toCharArray(),0,"");
//        }
//        public static void main(String[] args) {
//            String str = "abc";
//            solution(str);
//            System.out.println(list);
//        }
//    }
}
