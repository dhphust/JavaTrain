package leetcode.dynamicPlanning;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 求路径
 * 动态规划
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 * 小范围4*4观察规律，然后辐射式扩展考虑
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划
     * 辅助数组，dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
     * 从最后一个位置，依次往前补充数据
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int min = grid[0][0];
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    dp[i][j] = grid[i][j];
                else if(i == m - 1 && j != n - 1)
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                else if(i != m - 1 && j == n -1)
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }


    /**
     * 尝试法
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public static int minPathSum1(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        if (i == grid.length - 1 && j < grid[0].length - 1)
            return grid[i][j] + minPathSum1(grid, i, j + 1);
        if (j == grid[0].length - 1 && i < grid.length - 1)
            return grid[i][j] + minPathSum1(grid, i + 1, j);
        int right = minPathSum1(grid, i, j + 1);
        int down = minPathSum1(grid, i + 1, j);
        return grid[i][j] + Math.min(right, down);
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum1(grid, 0, 0));
        System.out.println(uniquePaths(7, 3));
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(2, 3);
        map.put(4, 5);
        map.put(3, 6);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}
