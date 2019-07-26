package leetcode;

public class Reverse {
    //    public static int reverse(int x) {
//        if (x == 0 || x > Integer.MAX_VALUE)
//            return 0;
//        boolean flag = true;
//        if(x < 0){
//            flag = false;
//        }
//        StringBuilder builder = new StringBuilder();
//        int abs  = Math.abs(x);
//        while(abs != 0){
//            int temp = abs % 10;
//            builder.append(temp);
//            abs = abs / 10;
//        }
//        //整型溢出判断
//        if(builder.toString().length() > 10)
//            return 0;
//        return (flag ? 1:-1) * (Integer.parseInt(builder.toString()));
//    }
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(2147483647));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
