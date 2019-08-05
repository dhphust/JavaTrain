package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * 定义一个list，list长度取numRows值，list中每个元素维护一个string，将字符根据行数限制
 * 依次追加到指定元素后面
 */
public class Convert {
    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows,s.length()); i++) {
             rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean flag =  false;
        for (int i = 0; i < s.length(); i++) {
             rows.get(curRow).append(s.charAt(i));
             if(curRow == 0 || curRow == numRows-1){
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
        System.out.println(convert(str,3));
//        int x = -123;
//        System.out.println(x % 10);
//        StringBuilder builder = new StringBuilder();
//        builder.append(4);
//        builder.append(5);
//        System.out.println(Integer.parseInt(builder.toString()));

    }
}
