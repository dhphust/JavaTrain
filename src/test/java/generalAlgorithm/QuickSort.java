package generalAlgorithm;


import java.util.Stack;


/**
 * 快排非递归
 */
public class QuickSort {

    public static void solution(int[] array){
        if(array == null || array.length < 2)
            return;
        quickSort(array,0,array.length-1);

    }

    //借助栈自己维护左右下标位置
    private static void quickSort(int[] array, int left, int right) {
        Stack<Integer> stack = new Stack<>();//存放首尾索引位置
        stack.push(left);
        stack.push(right);
        while(!stack.isEmpty()){
            right = stack.pop();
            left = stack.pop();
            //如果右边索引值小于等于左边索引，本次不比较
            if(right <= left) continue;
            int split = partition(array,left,right);
            //继续比较分割点左右部分
            if(left < split-1){
                stack.push(left);
                stack.push(split-1);
            }
            if(split+1 < right){
                stack.push(split+1);
                stack.push(right);
            }
        }

    }

    public static int partition(int[] array,int left,int right){
        int temp = array[left];
        while (left < right){
            while(left < right && array[right] >= temp) right--;
            if(left < right)
                array[left++] = array[right];
            while (left < right && array[left] <= temp) left++;
            if(left < right)
                array[right--] = array[left];
        }
        array[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,2,5,7,1,6,5,4,3};
        solution(arr);
        for(Integer result : arr){
            System.out.print(result + " ");
        }
    }
}
