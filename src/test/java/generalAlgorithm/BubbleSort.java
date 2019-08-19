package generalAlgorithm;
/**
 * 冒泡排序
 * 降序输出：通过相邻的两个元素大小比较，如果arry[i]>arry[i+1],交换元素值，一次遍历下来，最大值移动到数组的末尾；
 * //打印末尾值，继续比较剩下的n-1各元素，最终逆序输出
 */
public class BubbleSort {
    public static int[] sort(int[] arry){
        if(arry== null || arry.length < 2)
            return arry;
        for(int end = arry.length; end > 0; end--){ //控制每次比较的元素个数
            for(int i = 0;i < end-1; i++){
                if(arry[i] > arry[i+1]){
                    swap(arry,i,i+1);
                }
            }
        }
        return arry;
    }

    private static void swap(int[] arry, int i, int j) {
        int temp;
        temp = arry[i];
        arry[i] = arry[j];
        arry[j] = temp;
    }

    public static void main(String[] args) {
        int[] arry = {3,5,2,1,5,7,1,4};
        int[] result = sort(arry);
        for (int i : result) {
            System.out.print(i);
        }


    }
}
