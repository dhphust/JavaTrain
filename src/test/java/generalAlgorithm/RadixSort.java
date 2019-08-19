package generalAlgorithm;

/**
 * 基数排序
 * 定义：根据位的高低进行排序，也就是先按照个位排序，然后依据十位排序，以此类推
 * 算法适用：知道数的范围（1～1000）
 */
public class RadixSort {
    public static void radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        radixSort(array, 0, array.length - 1, maxbits(array));
    }

    //确定数组中元素的最高位
    public static int maxbits(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] array, int begin, int end, int digit) {
        final int radix = 10; //基数值
        int i = 0, j = 0;
        int[] count = new int[radix]; //
        int[] bucket = new int[end - begin + 1]; //缓存排序后的元素
        for (int d = 1; d <= digit; d++) { //从个位开始排序
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }
            //获取数组中元素 对应位数d的值
            for (i = begin; i <= end; i++) {
                j = getDigit(array[i], d);
                count[j]++;
            }

            //根据d位的值确定元素应该在bucket中的下标位置
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //将元素从后往前依次放入对应的bucket中
            for (i = end; i >= begin; i--) {
                j = getDigit(array[i], d);
                bucket[count[j] - 1] = array[i];
                count[j]--;
            }
            //缓存中的值赋值给array
            for (i = begin, j = 0; i <= end; i++, j++) {
                array[i] = bucket[j];
            }
        }
    }
    //获取指定位数d的值（456，2）-> 5
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        //如果存在负数，将数组1分为2，单独考虑；因为本算法未考虑负数，可将负数转化为正数，使用该算法
        int[] array = {23,45,123,2,43};
        radixSort(array);
        for(int result: array){
            System.out.print(result + " ");
        }
    }

}
