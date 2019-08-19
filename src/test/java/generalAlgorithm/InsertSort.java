package generalAlgorithm;
/**
 * 直接插入排序：将元素插入到已经排好序的子数组中，
 * 插入的元素从后往前依次与已经排好序的子数组比较
 */
public class InsertSort {
    public static int[] insertSort(int[] arry){
        if(arry == null || arry.length < 2)
            return arry;
        for (int i = 1; i < arry.length; i++) { //从第2个位置开始比较，因为第1个位置元素默认是排好序的
            for (int j = i; j > 0; j--) {
                if(arry[j] < arry[j-1])
                    swap(arry,j,j-1);
            }
        }
        return arry;
    }
    private static void swap(int[] arry, int j, int i) {
        int temp;
        temp = arry[i];
        arry[i] = arry[j];
        arry[j] = temp;
    }

    public static void main(String[] args) {
        int[] arry = {3,5,2,1,5,7,1,4};
        int[] result = insertSort(arry);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
