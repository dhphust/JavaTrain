package generalAlgorithm;

//归并：将待排序的数列分成若干个长度为1的子数列，然后将这些相邻数列两两合并；得到若干个长度为2的有序数列，
// 再将这些数列两两合并；得到若干个长度为4的有序数列，再将它们两两合并；
// 直接合并成一个数列为止。这样就得到了我们想要的排序结果
public class MergeSort {
    public static void mergeSort(int[] arry){
        if(arry == null || arry.length < 2)
            return;
        sortProcess(arry,0,arry.length-1);
    }

    public static void sortProcess(int[] arry,int leftIndex,int rightIndex){
        if(leftIndex == rightIndex)
            return;
        int mid = leftIndex+(rightIndex-leftIndex)/2;  //这种写法有效防止因rightIndex数字过大造成的rightIndex+leftIndex值溢出
        sortProcess(arry,leftIndex,mid);
        sortProcess(arry,mid+1,rightIndex);
        merge(arry,leftIndex,mid,rightIndex);


    }

    private static void merge(int[] arry, int leftIndex, int mid, int rightIndex) {
        int[] temp = new int[rightIndex-leftIndex+1];  //辅助数组，存放左右数列的合并数列
        int i =0;
        int p1 = leftIndex;
        int p2 = mid+1;
        while (p1 <= mid && p2 <= rightIndex){
            temp[i++] = arry[p1] < arry[p2] ? arry[p1++] : arry[p2++];
        }
        //将左数列/右数列剩下的元素一次性插入temp数组
        while (p1 <= mid){
            temp[i++] = arry[p1++];
        }
        while (p2 <= rightIndex){
            temp[i++] = arry[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arry[leftIndex+j]= temp[j];
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
        int[] arry = {3,5,2,1,5,7,1,4};
        mergeSort(arry);
        printArray(arry);

    }
}
