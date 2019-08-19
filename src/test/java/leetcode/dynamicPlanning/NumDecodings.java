package leetcode.dynamicPlanning;


/**
 * 解码方法
 * 递归方法：
 * 假设第一个字母由第一个字符组成，那么解法数an1=f(n-1);
 * 假设第一个字母由前两个字符组成，那么解法数an2=f（n-2）;
 * 总共的解法=an1+an2；
 */
public class NumDecodings {

    public static int numDecodings(String s) {
        int start = 0;
        return solution(s,start);
    }

    public static int solution(String s,int start){
        if(s.length() == start)
            return 1;
        if(s.charAt(start) == '0')
            return 0;
        int an1 = solution(s,start+1);
        //第二种情况，要考虑<26
        int an2 = 0;
        if(s.length() > 1 && start < s.length() - 1){
            String sub = s.substring(start,start + 2);
            int first = sub.charAt(0) - '0';
            int second = sub.charAt(1) - '0';
            if(first < 2 || (first == 2 && second <= 6)){
                an2 = solution(s,start+2);
            }
        }
        return an1 + an2;
    }
    public static void main(String[] args) {
        String str = "22121";
        System.out.println(numDecodings(str));

    }
}
