package leetcode.L290_WordPattern;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 2:55 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }

        // 一对一映射，不是等价关系
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            if (map.containsKey(p)) {
                if (!map.get(p).equals(strs[i])) {
                    return false;
                }
            } else if (map.containsValue(strs[i])) {
                return false;
            } else {
                map.put(p, strs[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(new Solution().wordPattern(pattern, str));
    }
}
