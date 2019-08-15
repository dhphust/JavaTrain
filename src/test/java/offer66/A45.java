package offer66;

import java.util.Arrays;

/**
 * 扑克牌问题
 */
public class A45 {
    public static boolean isContinuous(int[] array){
        if(array == null || array.length < 1)
            return false;
        Arrays.sort(array);//快排
        int zeroNum = 0;
        int addNum = 0;
        for(int i = 0; i < array.length-1; i++){
            if((array[i] == array[i+1]) && (array[i] != 0))//存在重复元素
                return false;
            if(array[i] == 0)//统计0的个数
                zeroNum++;
        }
//检查整个序列需要几个数字来补，记为m，如果m大于n，则返回false，否则返回true
        for(int j = 0; j < array.length-1; j++){
            if(array[j] != 0){
                addNum += (array[j+1]-array[j]-1);
            }
        }
        if(addNum > zeroNum)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,0,0,0,0};
        System.out.println(isContinuous(array));
    }

}
