package leetcode.L165_CompareVersionNumbers;


public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i, j;
        for (i = 0, j = 0; i < v1.length || j < v2.length;i++, j++) {
            int a = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int b = j < v2.length ? Integer.valueOf(v2[j]) : 0;
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
        }
        return 0;
    }
}
