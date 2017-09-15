package leetcode.L482_LicenseKeyFormatting;

/**
 * @author: deadend
 * @date: 9:29 PM 3/9/17
 * @version: 1.0
 * @description:
 */


class Solution {
    public String licenseKeyFormatting(String s, int k) {
        final int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = n - 1, count = 0; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (count == k) {
                    builder.insert(0, '-');
                    count = 0;
                }

                builder.insert(0, Character.toUpperCase(c));
                count++;
            }
        }

        return builder.toString();
    }
}

class OldSolution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuffer buffer = new StringBuffer();
        for (int i = S.length() - 1, cnt = 0; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (cnt == K) {     // 必要时才插入-
                    if (buffer.length() != 0) {
                        buffer.insert(0, '-');
                    }
                    cnt = 0;
                }
                buffer.insert(0, c);
                cnt++;
            }

        }
        return buffer.toString();
    }
}
