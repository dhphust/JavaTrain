package offer66;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */


public class Eight {
    public static int JumpFloor(int target) {
        int one = 1;
        int two = 2;
        int result = 0;
        if(target == 1){
            return one;
        }
        if(target ==2){
            return two;
        }
        for(int i =3;i<=target;i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 10;
        int jumpFloorResult = JumpFloor(target);
        System.out.println(jumpFloorResult);

    }
}
