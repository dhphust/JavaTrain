package generalAlgorithm;

import static generalAlgorithm.ShellSort.swap;

public class Solution {
    public static void solution(int[] array){
        if(array == null || array.length < 2)
            return;
        for(int i = 0; i < array.length; i++){
            initHeap(array,i);
        }

        int size = array.length;
        swap(array,0,--size);//首尾交换
        while(size > 0){
            heapify(array,0,size);//堆顶元素重新堆化
            swap(array,0,--size);
        }
    }

    //初始化大根堆，保证index位置元素小于父节点值
    public static void initHeap(int[] array, int index){
        while(index > 0 && (array[index] > array[(index-1)/2])){
            swap(array,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    //堆顶元素重新堆化
    public static void heapify(int[] array,int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int right = left + 1;
            int largest = right < size && array[left] < array[right] ? right : left;
            largest = array[largest] < array[index] ? index : largest;
            if(largest == index)
                return;
            swap(array,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public static void main(String[] args){
        int[] array = {3,7,-4,0,6,3,4,2,6,45};
        solution(array);
        for(int result : array)
            System.out.print(result + " ");
    }
}
