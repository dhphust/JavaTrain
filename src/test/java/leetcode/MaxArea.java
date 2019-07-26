package leetcode;

public class MaxArea {
    public static int maxArea(int[] height) {
        int sum  = 0;
        int maxSum = 0;
        int min = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                min = height[i] > height[j] ? height[j] : height[i];
                sum = (j - i) * min;
                if(maxSum < sum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
