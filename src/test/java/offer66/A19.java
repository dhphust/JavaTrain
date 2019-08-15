package offer66;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class A19 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer>  res = new ArrayList<Integer>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(rows == 0 || columns == 0) return res;
        int top = 0 , bottom = rows -1, left = 0 , right = columns -1;
        while(left <= right && top <= bottom){
            // left to right
            for(int i = left ; i<= right ; i++){
                res.add(matrix[top][i]);
            }
            // top to bottom
            for(int i = top + 1 ; i<= bottom ; i++){
                res.add(matrix[i][right]);
            }
            //right to left
            for(int i = right - 1 ; bottom > top&&  i>= left ; i--){
                res.add(matrix[bottom][i]);
            }
            //bottom to top
            for(int i = bottom - 1 ; left < right && i> top ; i--){
                res.add(matrix[i][left]);
            }

            top = top +1 ;  bottom = bottom - 1 ; left = left +1; right = right - 1;

        }

        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> results = printMatrix(matrix);
        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }
}
