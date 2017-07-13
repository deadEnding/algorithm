package leetcode.again.L471_EncodeStringWithShortestLength;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 2:00 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private boolean isPattern(String s, String ptn) {
        if (s.equals("")) {
            return true;
        }
        return  s.length() % ptn.length() == 0 && s.startsWith(ptn) && isPattern(s.substring(ptn.length()), ptn);
    }

    private String minEncode(String s, HashMap<String, String> cache) {
        if (s.length() <= 4) {
            return s;
        }

        if (!cache.containsKey(s)) {
            final int n = s.length();
            String min = s;
            for (int i = 1; i <= n / 2; i++) {
                String p = s.substring(0, i);
                if (isPattern(s, p)) {
                    String ne = String.format("%d[%s]", n / i, minEncode(p, cache));
                    if (min.length() > ne.length()) {
                        min = ne;
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                String e = minEncode(s.substring(0, i), cache) + minEncode(s.substring(i), cache);
                if (e.length() < min.length()) {
                    min = e;
                }
            }
            cache.put(s, min);
        }
        return cache.get(s);
    }


    public String encode(String s) {
        return minEncode(s, new HashMap<>());
    }

    public static void main(String[] args) {
        String s = "abbbabbb";
        System.out.println(new Solution().encode(s));
    }
}
