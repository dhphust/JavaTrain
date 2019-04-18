package offer66;

import java.util.Arrays;

public class Duplicate {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length < 1)
            return false;
        Arrays.sort(numbers);
        int j =0;
        for(int i = 0;i < length-1; i++){
            if(numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,4,2,1,4};
        int [] duplication = new int[0];
        boolean result = duplicate(numbers, 5,duplication);
        System.out.println(result);
    }
}
