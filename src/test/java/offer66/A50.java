package offer66;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 */
public class A50 {

    //方式一：借助辅助数组标记，当一个数字被访问后，就设置对应的数字+1
    public static int solution1(int[] numbers,int length){
        if(numbers.length == 0)
            return -1;
        int[] array = new int[length];
        for(int i = 0; i< length; i++){
            if(array[numbers[i]] == 1){
                return numbers[i];
            }
            array[numbers[i]] = 1;
        }
        return -1;
    }
    //方式二：借助hashMap<数，数出现的次数>
    public static int solution2(int[] numbers,int length){
        if(numbers.length == 0)
            return -1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< numbers.length; i++){
            if(map.containsKey(numbers[i])){
                return numbers[i];
            }
            map.put(numbers[i],1);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers = {4,5,2,3,2,4,6};
        int length = numbers.length;
        System.out.println(solution1(numbers,length));
        System.out.println(solution2(numbers,length));
    }
}
