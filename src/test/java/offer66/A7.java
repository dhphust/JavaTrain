package offer66;

/**
 * 斐波那契数列
 */
public class A7 {
    public static int Fibonacci(int n) {
        int one = 0;
        int two = 1;
        if(n <= 0) return one;
        if(n == 1) return two;
        int result = 0;
        for(int i = 2; i <= n; i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Fibonacci(6));
    }
}
