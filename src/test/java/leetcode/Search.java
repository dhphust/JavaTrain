package leetcode;

/**
 * 搜索旋转排序数组
 * 二分查找，先用二分查找找到最小值，将数组分成两部分，每部分都是单调递增
 * 再次利用二分查找，在子部分查找目标值
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class Search {

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length < 1)
            return -1;
        int left = 0;
        int right = nums.length -1;
        int split = findMinIndex(nums);
        int left_target = binarySearch(nums,left,split-1,target); //确定左半部分是否存在目标值
        int right_target = binarySearch(nums,split,right,target);//确定右半部分是否存在目标值
        if(left_target != -1)
            return left_target;
        if(right_target != -1)
            return right_target;
        return -1;
    }

    //二分法确定分界点
    public static int findMinIndex(int[] nums){
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] > nums[mid+1] && mid + 1 <= right)
                return mid + 1;
            else if(nums[mid] > nums[left]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left+1;
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
        int[] nums = {4,5,6,7,0,1,2};
//        int result = findMinIndex(nums);
//        System.out.println(result);
//        int[] nums1 = {4,5,6,7,8,9};
//        int search = binarySearch(nums1,0,nums1.length-1,8);
//        System.out.println(search);
        int result = search(nums,6);
        System.out.println(result);
    }
}
