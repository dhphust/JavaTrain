package leetcode;

/**
 * 下一个排序
 * 思路：定义两个指针，初始分别指向最后两个位置
 * 若后一个位置大于前一个位置，则交换两个位置值，输出；
 * 若指针移到位首，仍然没有交换元素，则逆序输出
 */
public class NextPermutation {

    public static int[] nextPermutation(int[] nums) {
        int end = nums.length - 1;
        while(end > 0){//从后往前扫描
            if(nums[end] > nums[end-1]){
                int target = end; //target为目标交换位置
                //先判断end->nums.length位置是否存在比nums[end-1]大，但是比nums[end]小，比如1，3，2
                for(int i = end; i <= nums.length -1; i++){
                    if(nums[i] > nums[end-1] && nums[i] < nums[target]){
                        target = nums[i];
                    }
                }
                swap(nums, target, end-1);
                int temp = end;
                while(temp < nums.length-1){
                    if(nums[temp] > nums[temp+1]){
                        swap(nums, temp, temp+1);
                        break;
                    }
                    temp++;
                }
                return nums;

            }
            end--;
        }

        //原序列已经是最大的排列，升序输出
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            swap(nums,left++,right--);
        }
        return nums;
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1};
        int[] result = nextPermutation(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

        }

    }
}
