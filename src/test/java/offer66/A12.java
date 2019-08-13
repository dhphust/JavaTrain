package offer66;

/**
 * 数值的整数次方
 * 1.写出指数的二进制表达，例如11表达为二进制1011。
 * 2.举例:10^1011 = 10^0001*10^0010*10^1000。
 * 3.通过&1和>>1来逐位读取1011，为1时将该位代表的乘数 累乘到最终结果。
 */
public class A12 {
//    public double Power(double base, int exponent) {
//        double result = 1;
//        int abs = Math.abs(exponent);
//        for(int i=1;i<=abs;i++){
//            result *=base;
//        }
//        if(exponent<0){
//            return 1/result;
//        }else
//            return result;
//
//    }
    public static double Power(double base, int exponent){
        double result = 1.0;
        int abs = Math.abs(exponent);
        while(abs != 0){
            if((abs&1) == 1)
                result *= base;
            base *= base; //翻倍
            abs >>= 1;  //右移一位
        }
        return exponent >= 0 ? result:1/result;
    }
    public static void main(String[] args) {
        System.out.println(Power(2,5));
    }
}
