package leetcode.dynamicPlanning;

public class ClimbStairs {
    public static int climbStairs(int n) {
        int one = 1;
        int two = 2;
        if(n == one)
            return one;
        if(n == two)
            return two;
        int sum = 0;
        for(int i = 3; i <= n; i++){
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
