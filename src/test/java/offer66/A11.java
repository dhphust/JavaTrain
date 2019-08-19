package offer66;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *  n&(n-1)作用：将n的二进制表示中的最低位为1的改为0
 *  n = 10100(二进制），则(n-1) = 10011 ==》n&(n-1) = 10000
 *  可以看到原本最低位为1的那位变为0。
 */
public class A11 {
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;

    }
    public static int Number2(int n){
        int count = 0;
        while(n+1 != 0){
            ++count;
            n = n | (n+1);
        }
        return count;
    }

    //直接通过&运算，将10进制转化为2进制
    public static void Number3(int n){
        int num0 = 0;
        int num1 = 0;
        while(n != 0){
            int result = n&1; //每次&运算，可以拿到对应二进制最低位的值
            if(result == 1)
                num1++;
            else if(result == 0)
                num0++;
            n >>= 1; //
        }
        System.out.println(num0+":"+num1);
    }

    public static void main(String[] args) {
        int number = 4;
        System.out.println(NumberOf1(number));
        System.out.println(Number2(number));
        Number3(number);
    }
}
