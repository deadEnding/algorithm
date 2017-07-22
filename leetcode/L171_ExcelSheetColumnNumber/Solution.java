package leetcode.again.L171_ExcelSheetColumnNumber;


public class Solution {
    public int titleToNumber(String s) {
        int x = 0;
        for (char c : s.toCharArray()) {
            x = x * 26 + c - 'A' + 1;
        }
        return x;
    }
}
