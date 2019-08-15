package offer66;

import java.util.ArrayList;

/**
 * 滑动窗口的最大值
 */
public class A64 {

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<>();
        if(num.length == 0)
            return null;
        if(size == 0)
            return null;
        for(int i = 0; i <= num.length - size; i++){
            int max = maxValue(num,i,i+size);
            result.add(max);
        }
        return result;
    }

    public static int maxValue(int[] num, int left, int right){
        int max = 0;
        for(int i = left; i < right; i++){
            if(num[i] > max)
                max = num[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int[] input = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> result = maxInWindows(input,4);
        System.out.println(result);
    }
}
