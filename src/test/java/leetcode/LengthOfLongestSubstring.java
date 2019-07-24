package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 滑动窗口、hashMap<character,index>
 */
public class LengthOfLongestSubstring {
        public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1)
            return 0;
//        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;//无重复区间的起始位置
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //确定下一次扫描起始位置
                index = Math.max(map.get(s.charAt(i))+1,index);
            }
            map.put(s.charAt(i),i);
            maxLength = Math.max(i-index+1,maxLength);//确定无重复区间长度

        }
        return maxLength;
    }
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;
//    }

    public static void main(String[] args) {

        String test = "abba";
        System.out.println(test.length());
        System.out.println(lengthOfLongestSubstring(test));
    }
}
