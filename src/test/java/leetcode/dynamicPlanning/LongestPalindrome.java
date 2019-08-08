package leetcode.dynamicPlanning;

/**
 * 最长回文子串
 * adabba
 * 动态规划
 */
public class LongestPalindrome {

    //暴露破解
//    public static String longestPalindrome(String s) {
//        char[] chars = s.toCharArray();
////        Map<Integer,Integer> map = new HashMap<>();//<huiwen>
//        int max_length = 0;
//        int index = 0;
//        for (int i = 0; i < chars.length; i++) {
//            for (int j = i+1; j < chars.length; j++) {
//                //两端扫，确定是否能构成回文
//                int left = i;
//                int right = j;
//                while(left <= right){
//                    if(chars[left] == chars[right]){
//                        left++;
//                        right--;
//                    }else
//                        break;
//                }
//                //构成回文
//                if(left > right){
//                    if((j - i) > max_length){
//                        max_length = j - i + 1;
//                        index = i;
//                    }
//                }
//            }
//        }
//        return s.substring(index,index + max_length);
//    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //计算（0，0）位置到（m,n）位置的最短路径
    public static int shortPaths(int[][] dp, int i, int j){

        if(i == dp.length - 1 && j == dp[0].length - 1)
            return dp[i][j];
        if(i == dp.length - 1)
            return dp[i][j] + shortPaths(dp,i,j+1);
        if(j == dp[0].length - 1)
            return dp[i][j] + shortPaths(dp,i+1,j);
        int right = shortPaths(dp,i,j+1);
        int down = shortPaths(dp,i+1,j);
        return dp[i][j] + Math.min(right,down);
    }
    public static int solution(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }
        return shortPaths(dp,0,0);
    }

    public static void main(String[] args) {
//        String result = longestPalindrome("asdabbaasd");
//        System.out.println(result);
        System.out.println(uniquePaths(7,3));
        System.out.println(solution(7,3));
    }
}
