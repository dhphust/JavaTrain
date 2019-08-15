package offer66;

/**
 * 左旋转字符串
 */
public class A43 {
    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0) return str;
        n %= len;//len = 9，左移12位时，和左移3位的结果是一样的，就会想到取余
        char[] str1=str.toCharArray();
        for(int i = 0, j = n - 1; i < j; ++i, --j) swap(str1,i,j);
        for(int i = n, j = len - 1; i < j; ++i, --j) swap(str1,i,j);
        for(int i = 0, j = len - 1; i < j; ++i, --j) swap(str1,i,j);
        return String.valueOf(str1);
    }
    public static void swap(char[] str, int left,int right){
        char temp;
        temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }

    public static void main(String[] args) {
        String str = "abcDEF123";
        int n = 3;
        System.out.println(LeftRotateString(str,n));
    }
}
