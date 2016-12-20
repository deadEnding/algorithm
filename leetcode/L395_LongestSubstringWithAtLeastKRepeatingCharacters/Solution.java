package leetcode.L395_LongestSubstringWithAtLeastKRepeatingCharacters;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:08 AM 12/20/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, int[]> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new int[]{1, i});
            } else {
                index.get(c)[0]++;
            }
        }

        Character minc = null;
        Character maxc = null;
        for (char c : index.keySet()) {
            minc = minc == null ? c : (index.get(c)[0] < index.get(minc)[0] ? c : minc);
            maxc = maxc == null ? c : (index.get(c)[0] > index.get(maxc)[0] ? c : maxc);
        }

        if (index.get(maxc)[0] < k) {
            return 0;
        }

        int[] tup = index.get(minc);
        return tup[0] >= k ? s.length() : Math.max(longestSubstring(s.substring(0, tup[1]), k),
                longestSubstring(s.substring(tup[1] + 1), k));
    }

    public static void main(String[] args) {
        String s = "baaabcb";
        int k = 3;
        System.out.println(new Solution().longestSubstring(s, k));
    }
}
