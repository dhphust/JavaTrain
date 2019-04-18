package generalAlgorithm;
//桶排序:基数排序
//计数排序的基本思想是：对每一个输入的元素arr[i]，确定小于 arr[i] 的元素个数m。
//所以可以直接把arr[i]放到它输出数组中的m+1位置上。假设有5个数小于 arr[i]，所以 arr[i] 应该放在数组的第6个位置上。

public class BucketSort {
    public static void bucketSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        //确定数组中的最大值、最小值
        int maxValue = Integer.MIN_VALUE;
        int minValue =Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue,arr[i]);
            minValue = Math.min(minValue,arr[i]);

        }
    //    System.out.println(maxValue);
        int[] temp = new int[maxValue + 1];
  //      System.out.println(temp.length);

        //确定数组中每个位置的元素个数信息
        for (int i = 0; i < arr.length; i++) {
            int position = arr[i]-minValue;
            temp[position]++;
        }
        //输出
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
           while (temp[i]-- > 0){
               arr[index++] = minValue + i;
           }

        }
    }

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
        int[] arr = {4,5,2,1,9};
        bucketSort(arr);
        printArray(arr);

    }
}
