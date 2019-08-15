package offer66;

/**
 * 正则表达式匹配
 */
public class A52 {
    public static boolean match(char[] str, char[] pattern)    {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }
    public static boolean matchCore(char[] str, int sindex, int pindex, char[] pattern){
        if(sindex >= str.length && pindex == pattern.length)
            return true;
        if(pindex >= pattern.length && sindex < str.length)
            return false;
        if(pindex+1 < pattern.length && pattern[pindex+1] == '*'){
            if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.') ){
                return matchCore(str, sindex, pindex+2, pattern) ||
                        matchCore(str, sindex+1, pindex+2, pattern ) ||
                        matchCore(str, sindex+1, pindex, pattern);
            }else{
                return matchCore(str, sindex, pindex+2, pattern);
            }
        }
        if(sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex+1, pindex+1, pattern);
        return false;
    }

    public static void main(String[] args) {
        String str = "aaa";
        String pattern = "a.a";
        System.out.println(match(str.toCharArray(),pattern.toCharArray()));
    }
}
