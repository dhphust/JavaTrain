package offer66;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 */
public class A42 {

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }

        }
        return list;
    }
    public static void main(String[] args) {
        int[] array = {2,3,4,5,8};
        int sum = 7;
        System.out.println(FindNumbersWithSum(array,sum));
    }
}
