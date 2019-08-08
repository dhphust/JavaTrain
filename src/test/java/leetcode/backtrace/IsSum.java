package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 序列中任何子序列的和=target
 */
public class IsSum {
    static List<String> result = new ArrayList<>();
    public static boolean solution(int[] nums,int target){
        return backtrace(nums,0,0,target);
    }
    public static boolean backtrace(int[] nums,int i, int res,int target){
//        if(i == res.length()){
//            int sum = 0;
//            for (int j = 0; j < res.length(); j++) {
//                sum += res.charAt(j);
//            }
//            if(sum == target)
//                result.add(res);
//        }
//        backtrace(nums,i+1,res,target);
//        backtrace(nums,i+1,res + String.valueOf(nums[i]),target);
        if(i == nums.length){
            return res == target;
        }
        return backtrace(nums,i+1,res,target) || backtrace(nums,i+1,res + nums[i],target);

    }

    public static void main(String[] args) {
        int[] nums = {-2,3,5,-1,4,7};
        int target = 4;
        System.out.println(solution(nums,target));
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }
    }
}
