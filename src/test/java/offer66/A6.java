package offer66;

/**
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
**/
 public class A6 {
    public static int minNumberInRotateArray(int [] array) {
        if(array.length <=0){
            return 0;
        }
        int i=0;
        int j=array.length-1;
        int mid = 0;
        while(i<=j){
            if(j-i == 1){
                mid = j;
                break;
            }
            mid = (j+i)/2;
            if(array[i] == array[mid] && array[i] == array[j]){ //[1,0,1,1,1]
                return MinInOrder(array,i,j);
            }else if(array[i] <= array[mid]){
                i = mid;
            }else if(array[mid] <= array[j]){
                j = mid;
            }
        }
        return array[mid];
    }
    public static int MinInOrder(int[] arr,int i,int j){
        int min = arr[i];
        for(int k=i+1 ; k<=j ; k++){
            if(arr[k] < min){
                min = arr[k];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        int result = minNumberInRotateArray(array);
        System.out.println(result);
    }
}
