package leetcode;

import java.util.*;

import static leetcode.NextPermutation.swap;

public class Solution {

    public static void solution(int[] array){
        if(array == null || array.length < 2)
            return;
        //初始化大根堆
        for(int i = 0; i < array.length; i++){
            initHeap(array,i);
        }
        //首尾交换
        int size = array.length-1;
        swap(array,0,size--);
        while(size > 0){
            heapify(array,0,size);//重新调整堆顶元素
            swap(array,0,size--);
        }
    }

    //初始化堆，保证index位置元素小于父节点位置元素
    public static void initHeap(int[] array, int index){
        while(index > 0){
            if(array[index] > array[(index-1)/2]){
                swap(array,index,(index-1)/2);
            }
            index = (index-1)/2;
        }

    }
    //重新堆化，确定新的最大值堆顶
    public static void heapify(int[] array, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int right = left + 1;
            //确定左右子树的最大值
            int largest = (right < size && array[left] < array[right]) ? right : left;
            largest = (array[largest] > array[index]) ? largest : index;
            if(largest == index)
                return;
            swap(array,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
    public static void main(String[] args) {
        int[] array = {5,4,2,0,78,3,-3};
        solution(array);
        for(int result : array)
            System.out.print(result + " ");
    }
}
