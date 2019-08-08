package leetcode.dynamicPlanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 最大子序列和
 */
public class MaxSubArray {

    //    public static int maxSubArray(int[] nums){
//        if(nums.length == 1)
//            return nums[0];
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i = 0; i < nums.length; i++) {
//
//            int max1 = nums[i];//最大和
//            int cur = 0;//当前和
//            for (int j = i; j < nums.length; j++) {
//                cur += nums[j];
//                if(cur > max1){
//                    max1 = cur;
//                }
//            }
//            //一轮后的最大值
//            set.add(max1);
//        }
//        return set.pollLast();
//    }

    /**
     * 动态规划
     * 如果sum有增益效果，加上；
     * 如果没有增益效果，抛弃sum，将当前数字赋值给sum
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(sum + nums[i]> nums[i]){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(sum,ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
