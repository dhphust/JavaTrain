package offer66;

/**
 * 调整数组的顺序，使基数位于偶数前面
 * 冒泡排序，每次前偶后奇就交换
 */
public class A13 {

    public static int[] reOrderArray(int [] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {3,6,4,7,2};
        int[] result = reOrderArray(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
