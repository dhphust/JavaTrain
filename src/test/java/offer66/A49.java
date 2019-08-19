package offer66;

/**
 * 字符串转整数
 * //ascii范围
 * 0～9:  48～57
 * A~Z:  65~90
 * a~z:  97~122
 */
public class A49 {

    public static int StrToInt(String str) {
        if(str == null || str.length() < 1)
            return 0;
        char[] a = str.toCharArray();
        int symbol = 0;
        int result = 0;
        if(a[0] == '-')
            symbol = 1;
        for(int i = symbol; i < a.length; i++){
            if(a[i] == '+')
                continue;
            if(a[i] < 48 || a[i] > 57)
                return 0;
            result = result * 10 + a[i] - 48;
        }
        return symbol > 0 ? -1 * result:result;

    }

    public static void main(String[] args) {
        String str = "+2147483647";
        System.out.println(StrToInt(str));
    }
}
