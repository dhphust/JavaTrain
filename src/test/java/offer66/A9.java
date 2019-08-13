package offer66;

/**
 * 变态跳
 */
public class A9 {
    public static int JumpFloorII(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        int a = 1;
        int b = 2;
        for (int i = 2; i <= target; i++) {
            b = 2 * a;
            a = b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(5));
    }
}
