package offer66;

/**
 * 矩形运行范围
 * 回溯法
 * 核心思路：
 * 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
 * 返回1 + 4 个方向的探索值之和。
 * 2.探索时，判断当前节点是否可达的标准为：
 * 1）当前节点在矩阵内；
 * 2）当前节点未被访问过；
 * 3）当前节点满足limit限制。
 */
public class A66 {

    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold,rows,cols,0,0,visited);
    }
    public static int countingSteps(int limit,int rows,int cols,int r,int c,boolean[][] visited){
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c] || bitSum(r) + bitSum(c) > limit)  return 0;
        visited[r][c] = true;
        return countingSteps(limit,rows,cols,r - 1,c,visited)
                + countingSteps(limit,rows,cols,r,c - 1,visited)
                + countingSteps(limit,rows,cols,r + 1,c,visited)
                + countingSteps(limit,rows,cols,r,c + 1,visited)
                + 1;
    }
    public static int bitSum(int t){
        int count = 0;
        while (t != 0){
            count += t % 10;
            t /= 10;
        }
        return  count;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(18,4,4));
    }
}
