import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void solution(int[] array){
        if(array == null || array.length < 2)
            return;
        quickSort(array,0,array.length-1);
    }
    public static void quickSort(int[] array,int left, int right){
        if(left > right)
            return;
        int split = partition(array,left,right);
        quickSort(array,left,split-1);
        quickSort(array,split+1,right);
    }
    public static int partition(int[] array,int left, int right){
        int temp = array[left];
        while(left < right){
            //从右往左扫描
            while(left < right && array[right] >= temp)
                right--;
            if(left < right){
                array[left++] = array[right];
            }
            //从左往右扫描
            while(left < right && array[left] <= temp)
                left++;
            if(left < right){
                array[right--] = array[left];
            }
        }
        array[left] = temp;
        return left;
    }

    public static void main(String[] args){
        int[] array = {3,4,6,2,4,8,5,-3,0,22};
        solution(array);
        for(int result : array){
            System.out.print(result + " ");
        }
        Set<String> set = new TreeSet<>();
        Collections.addAll(set,args);
        System.out.println(set);

    }
}
