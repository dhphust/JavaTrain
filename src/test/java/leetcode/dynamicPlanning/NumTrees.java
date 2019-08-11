package leetcode.dynamicPlanning;

/**
 * 不同的二插搜索数
 * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
 * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
 * f(i) = G(i-1)*G(n-i)
 * 综合两个公式可以得到 卡特兰数 公式
 * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 */
public class NumTrees {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}
