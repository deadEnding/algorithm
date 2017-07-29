package leetcode.L067_AddBinary;

/**
 * @author: deadend
 * @date: 2:16 PM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String addBinary(String a, String b) {
        final int m = a.length();
        final int n = b.length();

        StringBuffer result = new StringBuffer();
        int c = 0;
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; i--, j--) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + c;
            result.insert(0, sum % 2);
            c = sum / 2;
        }

        if (c != 0) {
            result.insert(0, c);
        }

        return result.toString();
    }
}


class OldSolution {
    public String addBinary(String a, String b) {
        final int m = a.length();
        final int n = b.length();

        StringBuffer result = new StringBuffer();
        int c = 0;
        for (int k = 0; k < Math.max(m, n); k++) {
            int x = k < m ? a.charAt(m - 1 - k) - '0' : 0;
            int y = k < n ? b.charAt(n - 1 - k) - '0' : 0;
            int sum = x + y + c;
            result.append(sum % 2);
            c = sum / 2;
        }
        if (c != 0) {
            result.append(c);
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }

}
