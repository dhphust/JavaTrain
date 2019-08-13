package offer66;

/**
 * 二位数组的查找
 */
public class A1 {
    public static boolean Find(int target, int [][] array) {
        int len = array.length-1;     //获取行长度
        int i = 0;
        while((len >= 0)&&(i < array[0].length)){  //获取列长度
            if(array[len][i] > target){
                len--;
            }else
            if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
        System.out.println(Find(4,array));
    }
}
