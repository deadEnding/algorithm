package leetcode.again.L551_StudentAttendanceRecordI;


public class Solution {
    public boolean checkRecord(String s) {
        int a = 0, l = 0, maxl = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                maxl = Math.max(maxl, ++l);
            } else {
                l = 0;
                a += c == 'A' ? 1 : 0;
            }
        }

        return a <= 1 && maxl <= 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord("PPALLL"));
    }
}
