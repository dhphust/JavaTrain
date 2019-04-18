package offer66;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *  n&(n-1)作用：将n的二进制表示中的最低位为1的改为0
 *  n = 10100(二进制），则(n-1) = 10011 ==》n&(n-1) = 10000
 *  可以看到原本最低位为1的那位变为0。
 */
public class eleven {
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;

    }

//    private static int NumberOf1_low(int n) {
//        int count = 0;
//        int flag = 1;
//        while (flag != 0) {
//            if ((n & flag) != 0) {
//                count++;
//            }
//            flag = flag << 1;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        int number = 10;
        int oneCount = NumberOf1(number);
        System.out.println(oneCount);
//        int oneCount1 = NumberOf1_low(number);
//        System.out.println(oneCount1);
    }
}
