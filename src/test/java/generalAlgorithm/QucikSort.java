package generalAlgorithm;


//快排：在待排序的n个记录中任取一个记录(通常取第一个记录),把该记录放入适当位置后,
// 数据序列被此记录划分成两部分。所有关键字比该记录关键字小的记录放置在前一部分，
// 所有比它大的记录放置在后一部分,
// 并把该记录排在这两部分的中间(称为该记录归位),这个过程称作一趟快速排序。
public class QucikSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int leftIndex, int rightIndex){
        if(leftIndex < rightIndex){
            int split = partition(arr,leftIndex,rightIndex);
            quickSort(arr,leftIndex,split-1);
            quickSort(arr,split+1,rightIndex);
        }

    }

    /**
     * 确定分割点,左右两头扫描比较值
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @return 分割元素的下标值
     */
    private static int partition(int[] arr, int leftIndex, int rightIndex) {
        while(leftIndex < rightIndex){
            int key = leftIndex; //待比较值下标
         //   int value = arr[key];
            //先从后往前比较
            while(leftIndex < rightIndex && arr[rightIndex] > arr[leftIndex])
                rightIndex--;
            //遇到比key小的元素，交换
            if(leftIndex < rightIndex && arr[rightIndex] <= arr[leftIndex]){
                swap(arr,key,rightIndex);
                leftIndex++;
            }
          //从前往后比较

            while(leftIndex < rightIndex && arr[leftIndex] < arr[rightIndex])
                leftIndex++;
            //遇到比key大的值，交换
            if(leftIndex < rightIndex && arr[leftIndex] > arr[rightIndex]){
                swap(arr,rightIndex,leftIndex);
                rightIndex--;
            }
        }
        return leftIndex;
    }


    private static void swap(int[] arry, int i, int i1) {
        int temp;
        temp = arry[i];
        arry[i] = arry[i1];
        arry[i1] = temp;
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
        int[] arr = {3,8,2,5,7,1,6,5,4};
        quickSort(arr);
    //    partition(arr,0,arr.length-1);
        printArray(arr);
    }
}
