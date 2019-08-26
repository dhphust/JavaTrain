package leetcode;

/**
 * 最长公共前缀
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1)
            return "";
        char[] chars = strs[0].toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = 1;
            for(int j = 1; j < strs.length; j++){
                if(i < strs[j].length() && strs[j].charAt(i) == chars[i]){
                    index++;
                }
            }
            if(index == strs.length)
                count++;
            else
                break;
        }
        if(count > 0)
            return strs[0].substring(0,count);
        return "";
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0) {
                System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(strs));
    }
}
