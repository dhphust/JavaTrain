package leetcode;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        List<Integer> result1 = new ArrayList<>();
//        if(nums.length < 1)
//            return null;
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i+1; j < nums.length; j++){
//                for(int k = j+1; k < nums.length; k++){
//                    if(nums[i] + nums[j] + nums[k] == 0){
//                        if(nums[i] > nums[j]){
//                            int temp = nums[i];
//                            nums[i] = nums[j];
//                            nums[j] = temp;
//                        }
//
//                        //sort
//                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
////                        result1.add(nums[i]);
////                        result1.add(nums[j]);
////                        result1.add(nums[k]);
////                        result.add(result1);
//                    }
//                }
//            }
//        }
//        return result;
//    }

    //排序，选定一个定值，两端扫描
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > 0)
                break;
            if(i>2&&(nums[i]=nums[i-1]=nums[i-2])==0){
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
                    if (!result.contains(temp))
                        result.add(temp);
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }
}
