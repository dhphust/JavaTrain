package offer66;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 */
public class A41 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int left = 1;
        int right = 2;
        while(left < right){
            int currentSum = (left + right)*(right - left + 1)/2;
            if(currentSum == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = left; i <=right; i++){
                    list.add(i);
                }
                result.add(list);
                left++;
            }
            else if(currentSum < sum){
                right++;
            }
            else{left++;}
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = FindContinuousSequence(100);
        System.out.println(result);
    }
}
