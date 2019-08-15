package offer66;

/**
 * 不用加减乘除做加法
 */
public class A48 {

    public static int Add(int num1,int num2) {
        int sum,mark;
        do{
            sum = num1^num2;   //异或操作，实现二进制的每位相加，不考虑进位
            mark = (num1&num2)<<1; //通过与操作，计算进位值
            num1=sum;
            num2=mark;
        }while(num2!=0); //终止条件，进位值为0
        return num1;
    }

    public static void main(String[] args) {
        int result = Add(5,7);
        System.out.println(result);
    }
}
