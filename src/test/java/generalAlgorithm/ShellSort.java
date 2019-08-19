package generalAlgorithm;

/**
 * 希尔排序
 * 定义：将待排序的数组元素按照下标的一定增量，分成多个子序列；
 * 然后对各个子序列进行插入排序；然后依次缩减增量再进行排序，直到增量d=1,
 * 进行最后一次插入排序，排序结束
 */
public class ShellSort {

    public static void shellSort(int[] array){
        if(array == null || array.length < 2)
            return;
        //确定步长
        int d = array.length / 2;
        while(d > 0){
            for(int i = 0; i < array.length; i++){
                //进行插入排序
                for(int j = i; j < array.length - d; j += d){
                    if(array[j] > array[j+d])
                        swap(array,j,j+d);
                }
            }
            d /= 2;//设置新的增量
        }
    }
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {3,4,52,1,3,5};
        shellSort(array);
        for(int result : array){
            System.out.print(result + " ");
        }
    }
}
