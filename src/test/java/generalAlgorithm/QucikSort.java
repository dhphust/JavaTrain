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
//    private static int partition(int[] arr, int leftIndex, int rightIndex) {
////        while(leftIndex < rightIndex){
////            int key = leftIndex; //待比较值下标
////         //   int value = arr[key];
////            //先从后往前比较
////            while(leftIndex < rightIndex && arr[rightIndex] > arr[leftIndex])
////                rightIndex--;
////            //遇到比key小的元素，交换
////            if(leftIndex < rightIndex && arr[rightIndex] <= arr[leftIndex]){
////                swap(arr,key,rightIndex);
////                leftIndex++;
////            }
////          //从前往后比较
////
////            while(leftIndex < rightIndex && arr[leftIndex] < arr[rightIndex])
////                leftIndex++;
////            //遇到比key大的值，交换
////            if(leftIndex < rightIndex && arr[leftIndex] > arr[rightIndex]){
////                swap(arr,rightIndex,leftIndex);
////                rightIndex--;
////            }
////        }
////        return leftIndex;
//        int temp = arr[leftIndex];
//        while(leftIndex < rightIndex){
//            while(leftIndex < rightIndex && arr[rightIndex] > temp) rightIndex--;
//            if(leftIndex < rightIndex)
//                arr[leftIndex++] = arr[rightIndex];
//            while (leftIndex < rightIndex && arr[leftIndex] < temp) leftIndex++;
//            if(leftIndex < rightIndex)
//                arr[rightIndex--] = arr[leftIndex];
//        }
//        arr[leftIndex] = temp;
//        return leftIndex;
//    }

    public static int partition(int[] array,int left, int right){
        int temp = array[left];
        while(left < right){
            //从右往左扫描
            while(left < right && array[right] > temp)
                right--;
            if(left < right){
                array[left++] = array[right];
            }
            //从左往右扫描
            while(left < right && array[left] < temp)
                left++;
            if(left < right){
                array[right--] = array[left];
            }
        }
        array[left] = temp;
        return left;
    }

    private static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
        int[] arr = {3,8,2,5,7,1,6,5,4,3};
        quickSort(arr);
    //    partition(arr,0,arr.length-1);
        printArray(arr);
    }
}
