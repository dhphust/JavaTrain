package offer66;

/**
 * 构建乘积数组
 */
public class A51 {

    public static int[] multiply(int[] array) {
        int[] B = new int[array.length];
        for(int i =0 ; i < array.length; i++){
            B[i] = 1;
            for(int j =0; j < array.length; j++){
                if(i != j){
                    B[i] *= array[j];
                }
            }
        }
        return B;
    }
    
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] result = multiply(array);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
