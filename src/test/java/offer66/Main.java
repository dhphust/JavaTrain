package offer66;

public class Main {

    public static void solution(int[] array){
        if(array == null || array.length < 2)
            return;
        quickSort(array,0,array.length-1);
    }
    public static void quickSort(int[] array, int left, int right){
        if(left < right){
            int split = partition(array,left,right);
            quickSort(array,left,split-1);
            quickSort(array,split+1,right);
        }
    }
    public static int partition(int[] array,int left,int right){
        int temp = array[left];
        while(left < right){
            while(left < right && array[right] > temp) right--;
            if(left < right)
                array[left++] = array[right];
            while(left < right && array[left] < temp) left++;
            if(left < right)
                array[right--] = array[left];
        }
        array[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {5,4,7,8,3,4};
        solution(array);
        for(int result : array){
            System.out.println(result);
        }
    }
}

