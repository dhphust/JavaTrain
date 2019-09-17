import generics.Comparable;
import generics.coffehouse.Cup;
import leetcode.Reverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static generalAlgorithm.ShellSort.swap;
import static java.util.Arrays.sort;

//求最大正方形面积转化为求最大边长
//定义一个初始化最大边长maxLength=0
//对每个值=1的点进行遍历
//判断它能否作为最小正方形矩阵右上顶点
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int N = input.nextInt();//输入行数
//        int M = input.nextInt();//输入列数
//        int[][] array = new int[N][];
//        //输入矩阵
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                array[i][j] = input.nextInt();
//            }
//        }
//        int maxLength = 0; //定义最大边长
//        for (int i = 1; i < N; i++) {
//            for (int j = 1; j < M; j++) {
//                if (array[i][j] == 1){
//                    //以array[i][j]为定点求右上最小正方形
//                    int temp = minValue(array[i][j-1],array[i-1][j],array[i-1][j-1]);
//                    if(temp != 0){
//                        array[i][j] = temp + 1;
//                        if(array[i][j] > maxLength)//判断右上顶点值>当前最大边长
//                            maxLength = array[i][j];
//                    }
//                }
//
//            }
//        }
//
//    }
//
//    //取三个整数的最小值
//    private static int minValue(int i, int i1, int i2) {
//        i = i < i1 ? i : i1;
//        i = i < i2 ? i : i2;
//        return i;
//    }
//}

public class Main{
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i <= j){
            if(chars[i++] != chars[j--])
            return false;
        }
        return true;
    }
    public static int solution1(int[] array){
        int min = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
              min = array[i] > array[j] ? j : i;
              sum = array[min] * (j - i);
              if(sum > max)
                  max = sum;
            }
        }
        return max;
    }

    //贪心算法
    public static String solution2(int num){
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (index < nums.length){
            while(num >= nums[index]){
                builder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
       return builder.toString();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            int temp = -1 * nums[i];//固定点
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                List<Integer> list = new ArrayList<>();
                if(nums[left] + nums[right] > temp){
                    right--;
                }else if(nums[left] + nums[right] < temp){
                    left++;
                }else {
                    list.add(-temp);
                    list.add(nums[left++]);
                    list.add(nums[right--]);
                }
                if(list.size() > 0 && !lists.contains(list)){
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    //最长回文：指定范围两端扫
    public static String longestPalindrome(String str){
        if(str == null)
            return null;
        char[] chars = str.toCharArray();
        int max = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                int left = i;
                int right = j;
                while (left < right){
                    if(chars[left++] != chars[right--]){
                        break;
                    }
                }
                if(left >= right && (j-i+1) > max){//存在回文
                    max = j-i+1;
                    index = i;
                }
            }
        }
        System.out.println(index);
        System.out.println(max);
        return str.substring(index,index+max);
    }

    //最长公共子串
    public static String solution3(String str1,String str2){
        //"abdsbf"
        //asdbdsbwe"

        int max = 0;
        int index = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int curNum = 0;
                int str1Index = i;
                int str2Index = j;
                while (str1Index < str1.length() && str2Index < str2.length() && str1.charAt(str1Index++) == str2.charAt(str2Index++)){
                    curNum++;
                }
                if(curNum > max){
                  max = curNum;
                  index = i;
                }
            }
        }
        System.out.println(max);
        System.out.println(index);
        return str1.substring(index,index+max);
    }

    //删除重复项

    public static int remove1(int[] array){
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] != array[index]){
                array[++index] = array[i];
            }
        }
        return index;
    }
    //移除指定元素
    public static int removeElement(int[] nums, int val) {

        int index = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }


    public static void main(String[] args) {
//        boolean result = isPalindrome(121);
//        System.out.println(result);
//        int[] array = {1,8,6,2,5,4,8,3,7};
//        System.out.println(solution1(array));
//        int num = 1994;
//        System.out.println(solution2(num));
//        String str = "abcde";
//        if(str.startsWith("ab"))
//            System.out.println("yes");
//        else
//            System.out.println("no");
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        System.out.println(threeSum(nums));
//        System.out.println(longestPalindrome("baabaad"));
//        System.out.println(solution3("sabdsbfa","qeqbdsbwe"));
//        int[] array = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(remove1(array));
//        for(int result : array)
//            System.out.print(result + " ");

        
    }

}












