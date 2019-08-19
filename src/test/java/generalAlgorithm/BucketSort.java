package generalAlgorithm;
//桶排序:
//根据数组中数据范围确定桶的个数（max-min+1），新建一个辅助数组，大小为桶数
//之后扫描原始数组，针对每个值，放到对应下标为桶编号的数组中，数组中只是记录对应元素的个数
//针对相同的值，对应桶数组的值+1操作；
//最后顺序打印辅助数组，辅助数组中的值=对应桶编号的元素的个数

public class BucketSort {
    public static int[] bucketSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        int min = array[0];
        int max = array[0];
        //确定数组中的最大值/最小值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            else if (array[i] < min)
                min = array[i];
        }
        //定义桶的大小
        int[] bucket = new int[max - min + 1];
        //确定数组中的元素放到桶的位置
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] - min]++;
        }
        //输出排序后的元素
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                array[index++] = i + min;
                bucket[i]--;
            }
        }
        return array;
    }

    //    public static void bucketSort(int[] arr){
//        if(arr == null || arr.length < 2)
//            return;
//        //确定数组中的最大值、最小值
//        int maxValue = Integer.MIN_VALUE;
//        int minValue =Integer.MAX_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            maxValue = Math.max(maxValue,arr[i]);
//            minValue = Math.min(minValue,arr[i]);
//
//        }
//        int[] temp = new int[maxValue - minValue + 1];
//        //确定数组中每个位置的元素个数信息
//        for (int i = 0; i < arr.length; i++) {
//            int position = arr[i]-minValue;
//            temp[position]++;
//        }
//        //输出
//        int index = 0;
//        for (int i = 0; i < temp.length; i++) {
//           while (temp[i]-- > 0){
//               arr[index++] = minValue + i;
//           }
//
//        }
//    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 34, 2342, 9};
        bucketSort(arr);
        printArray(arr);

    }
}
