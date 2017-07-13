package leetcode.L482_LicenseKeyFormatting;

/**
 * @author: deadend
 * @date: 7:19 PM 2/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer sb = new StringBuffer();
        StringBuffer tmp = new StringBuffer();
        S = S.toUpperCase();
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch == '-') {
                continue;
            }

            tmp.insert(0, ch);
            if (tmp.length() == K || i == 0) {
                sb.insert(0, sb.length() != 0 ? "-" : "");
                sb.insert(0, tmp.toString());
                tmp = new StringBuffer();
            }
        }
        if (tmp.length() > 0) {
            sb.insert(0, sb.length() > 0 ? tmp.toString() + "-" : tmp.toString());
        }
        return sb.toString();
    }
}
