package offer66;

import java.util.Arrays;
import java.util.Comparator;

public class A32 {

    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0 || numbers == null)
            return "";
        String[] str = new String[numbers.length];
        for(int i=0;i<numbers.length;i++ ){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String c1 = str1 + str2;
                String c2 = str2 + str1;
                return c1.compareTo(c2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<str.length;i++){
            sb.append(str[i]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
}
