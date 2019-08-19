package offer66;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 二叉树的下一个节点
 */
public class Main {
        public static void solution(int[] array){
            if(array.length < 2 || array == null)
                return;
            mergeSort(array,0,array.length-1);
        }
        public static void mergeSort(int[] array, int left, int right){
            if(left == right)
                return;
            int mid = (left + right) >> 1;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }

        //将左右子序列归并到一个序列
        public static void merge(int[] array,int left, int mid, int right){
            int[] temp = new int[right - left + 1];
            int p1 = left;
            int p2 = mid + 1;
            int i = 0;
            while(p1 <= mid && p2 <=right){
                temp[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
            }
            while(p1 <= mid)
                temp[i++] = array[p1++];
            while(p2 <= right)
                temp[i++] = array[p2++];
            for(int j = 0; j < temp.length; j++)
                array[left + j] = temp[j];
        }

        public static void main(String[] args) {
            int[] array = {3,4,3,2,5,6};
            solution(array);
            for(int result : array)
                System.out.println(result);
        }
    }

