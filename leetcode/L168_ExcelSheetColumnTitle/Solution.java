package leetcode.L168_ExcelSheetColumnTitle;


public class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            builder.append((char) ((n - 1) % 26 + 'A'));
            n= (n - 1) / 26;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(28));
    }
}
