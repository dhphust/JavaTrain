package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

/**
 * Z 字形变换
 * 定义一个list，list长度取numRows值，list中每个元素维护一个string，将字符根据行数限制
 * 依次追加到指定元素后面
 */
public class Convert {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                flag = !flag;
            }
            curRow += flag ? 1 : -1;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder row : rows) {
            builder.append(row);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "leetcodeishiring";
        System.out.println(convert(str, 3));

        System.out.println('5'-'0');
        System.out.println('b'-'a');
        solution("words and 987");


    }
    public static void solution(String str){
        if(str == null)
            return;
        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '-'){
                builder.append(chars[i]);
                continue;
            }
            if(chars[i] == ' ')
                continue;
            if(chars[i] != ' ' && (chars[i] >= '0' && chars[i] <= '9'))
                builder.append(chars[i]);
            else{
                break;
            }

        }
        if(builder.toString().length() == 0)
            builder.append(0);
        Integer result = Integer.valueOf(builder.toString());
        Integer.parseInt(builder.toString());
        System.out.println(builder);

    }

}


