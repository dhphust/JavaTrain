package offer66;

import java.util.ArrayList;

/**
 * 最小的K个数
 */
public class A29 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if (k > input.length) {
            return al;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);
        }
        return al;
    }

    public static void main(String[] args) {
        int[] put = {4,5,1,6,2,7,3,8};
        int k =4;
        ArrayList<Integer> result = GetLeastNumbers_Solution(put,k);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

}
