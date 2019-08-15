package offer66;


/**
 * 统计一个数字在排序数组中出现的次数
 */
public class A37 {

    public static int GetNumberOfK(int [] array , int k) {
        int index = binarySearch(array,0,array.length-1,k);//二分法先确定位置
        int count = 1;
        //index位置的左右两边扫描，确定k值个数
        int i = 1;
        while(array[index-i] == k){
            count++;
            i--;
        }
        int j = 1;
        while (array[index + j] == k){
            count++;
            j++;
        }
        return count;
    }

    public static int binarySearch(int[] nums, int left, int right, int target){
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] > target)
                right = mid - 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {1,3,4,5,5,5,6,7};
        int target = 5;
        System.out.println(GetNumberOfK(array,target));
    }
}
