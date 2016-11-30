package leetcode.L038_CountAndSay;

/**
 * @author: deadend
 * @date: 2:05 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while (--n > 0) {
            s = next(s);
        }
        return s;
    }

    private String next(String s) {
        StringBuffer sb = new StringBuffer();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char bc = s.charAt(i - 1);
            char c = s.charAt(i);
            if (c == bc) {
                count++;
            } else {
                sb.append(count);
                sb.append(bc);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(3));
    }
}
