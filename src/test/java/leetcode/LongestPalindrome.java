package leetcode;

/**
 * 最长回文子串
 * abbadf->abba       abbaaabbdf
 * abcbadf->abcba
 * 中心扩展算法，因为回文中心的两侧互为镜像，所以可以从它的中心展开，并且有2n-1个这样的中心
 *为什么中心是2n-1而不是n 比如有字符串abcba，这时回文子串是abcda，中心是c；
 * 又有字符串adccda，这时回文子串是adccda，中心是cc。
 * 由此可见中心点既有可能是一个字符，也有可能是两个字符，当中心为一个字符的时候有n个中心，
 * 当中心为两个字符的时候有n-1个中心，所以一共有2n-1个中心。
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s){
        if(s == null || s.length() < 1)
            return "";
        int start = 0;//回文子串的起始位置
        int end = 0;//回文子串的结束位置
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i);//中心为一个字符
            int len2 = expandAroundCenter(s,i,i+1);//中心为两个字符
            int len = Math.max(len1,len2);
            if(len > end - start){ //最新的回文子串
                start = i- (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1);
    }
    //判断左右是否互为镜像
    private static int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        return right - left -1;
    }

    public static void main(String[] args) {
        String s = "abbaaabbdf";
        System.out.println(longestPalindrome(s));
    }
}
