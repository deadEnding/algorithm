package leetcode.L165_CompareVersionNumbers;

/**
 * @author: deadend
 * @date: 8:40 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int a = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int b = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (a != b) {
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.1", "1"));
    }
}