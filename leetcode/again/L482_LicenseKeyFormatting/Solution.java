package leetcode.again.L482_LicenseKeyFormatting;

/**
 * @author: deadend
 * @date: 9:29 PM 3/9/17
 * @version: 1.0
 * @description:
 */


public class Solution {
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
