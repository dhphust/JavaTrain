package offer66;

/**
 * 数组中只出现一次的数字
 */
public class A40 {

    public static void FindNumsAppearOnce(int [] array) {
        if (array == null || array.length < 2)
            return;
        int result = 0;
        for (int item : array)
            result ^= item;
        int firstIndex = findFirstIndex(result);
        int num1 =0;
        int num2 =0;
        for(int item:array){
            if(isBit1(item,firstIndex))
                num1 ^= item;
            else
                num2 ^= item;
        }
        System.out.println(num1 +":"+num2);
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

    public static void main(String[] args) {
        int[] array = {3,4,5,3,5,2};
        FindNumsAppearOnce(array);
    }
}
