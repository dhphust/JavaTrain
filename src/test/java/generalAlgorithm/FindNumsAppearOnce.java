package generalAlgorithm;

import java.util.ArrayList;

import static generalAlgorithm.BubbleSort.sort;

//异或运算，相同数字异或后等于0
public class FindNumsAppearOnce {
    public static ArrayList<Integer> findNumsAppearOnce(int [] array, int[] num1 , int[] num2){
        if (array == null || array.length < 2)
            return null;
        int resultExclusiveNor = 0;
        for (int item : array)
            resultExclusiveNor ^= item;
        int firstIndex = findFirstIndex(resultExclusiveNor);
        num1[0]=0;
        num2[0]=0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int item:array){
            if(isBit1(item,firstIndex))
                num1[0]^=item;
            else
                num2[0]^=item;
        }
        result.add(num1[0]);
        result.add(num2[0]);
        return result;
    }
    // 二进制数 从右往左 找到第一个 "1"
    public static int findFirstIndex(int n) {
        int index = 0;
        while ((1 & n) == 0 && index < 32) {
            n = n >> 1;
            index++;
        }
        return index;
    }
    //判断这个数的二进制形式从左到右index位是否为"1"
    public static boolean isBit1(int num, int index) {
        boolean check = false;
        num = num >> index;
        if ((num & 1) == 1)
            check = true;
        return check;

    }

    public static ArrayList<Integer> test(int[] array){
        array = sort(array);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < array.length; i = i + 2){
            if(array[i] != array[i+1])
            {
                result.add(array[i]);
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,3,4,6,9,6};
//        int[] array = {3,4,5,4,3,5};
        int[] num1 = {0};
        int[] num2 = {0};
        ArrayList<Integer> result = findNumsAppearOnce(array, num1, num2);
        for (Integer integer : result) {
            System.out.println(integer);
        }

        System.out.println("second method：");
        ArrayList<Integer> result1 = FindNumsAppearOnce.test(array);
        for (Integer integer : result1) {
            System.out.println(integer);
        }

    }
}

