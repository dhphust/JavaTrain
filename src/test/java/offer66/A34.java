package offer66;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 第一个只出现一次的字符
 */
public class A34 {
    public static int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        char[] list = str.toCharArray();
        int index = 0;
        for(int i=0;i<list.length;i++){
            boolean rag = false;
            for(int j=0; j < list.length; j++){
                if(list[j] == list[i] && j != i){
                    rag = true;
                    break;
                }
            }
            if(!rag){
                index = i;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int result = FirstNotRepeatingChar("goolgleda");
        System.out.println(result);
    }
}
