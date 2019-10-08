public class Solution {
    public static void solution(int[] array){
        if(array == null || array.length < 1)
            return ;
        quickSort(array,0,array.length-1);
    }

    public static void quickSort(int[] array, int left, int right){
        if(left > right)
            return;
        int split = partition(array,left,right);
        quickSort(array,left,split-1);
        quickSort(array,split+1,right);
    }

    public static int partition(int[] array, int left, int right){
        int temp = array[left];
        while(left < right){
            //从右往左扫描，当遇到比枢纽点小的值交换
            while(left < right && array[right] >= temp)right--;
            if(left < right){
                array[left++] = array[right];
            }
            //从左往右扫描，遇到比枢纽点大的交换
            while(left < right && array[left] <= temp) left++;
            if(left < right){
                array[right--] = array[left];
            }
        }
        array[left] = temp;
        return left;
    }
    public static void main(String[] args){
        int[] array = {3,4,6,2,4,8,5,-3,0,22};
        solution(array);
        for(int result : array){
            System.out.print(result + " ");
        }
    }

}
