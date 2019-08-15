package offer66;

import java.util.Arrays;

/**
 * 中位数
 * 从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class A63 {

    public static int solution(int[] array) {
        if (array.length == 0)
            return -1;
        int length = array.length;
        Arrays.sort(array);
        if (length % 2 == 1) {//奇数
            return array[(length + 1) / 2 - 1];
        } else { //偶数
            int mid = array[length / 2 - 1] + array[length / 2];
            return mid / 2;
        }
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,6,8};
        System.out.println(solution(array));
    }
}
