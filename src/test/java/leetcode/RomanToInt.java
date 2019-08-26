package leetcode;

/**
 * 字符串对应的数字之和
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int sum = 0;
        while (s.length() > 0){
            int index = 0;
            while(index < romans.length){
                if(s.startsWith(romans[index])){
                    sum += nums[index];
                    s = s.substring(romans[index].length());
                }
                index++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
