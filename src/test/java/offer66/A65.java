package offer66;

/**
 * 确定从左上角到右下角最短路径
 * 坐标（i，j）
 */
public class A65 {
    public static int walk(int[][] matrix,int i ,int j){
        //递归结束条件
        if(i == matrix.length-1 && j == matrix[0].length-1)
            return matrix[i][j];
        if(i == matrix.length -1){//假设到达最后一行
            return matrix[i][j] + walk(matrix,i,j+1);//只能右移
        }
        if(j == matrix.length -1){//假设到达最后一列
            return matrix[i][j] + walk(matrix,i+1,j);//只能下移
        }
        //计算路径
        int down = walk(matrix,i+1,j);//向下走一步
        int right = walk(matrix,i,j+1);//向右走一步
        return matrix[i][j] + Math.min(down,right);
    }

    public static void main(String[] args) {
        int[][] res = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,9}};
        System.out.println(walk(res,0,0));

    }
}
