package leetcode.L481_MagicalString;

/**
 * @author: deadend
 * @date: 7:18 PM 2/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int magicalString(int n) {
        if (n <= 3) {
            return n > 0 ? 1 : 0;
        }

        StringBuffer sb = new StringBuffer("122");
        int ix = 2;
        int count = 1;
        while (sb.length() < n) {
            int x = sb.charAt(ix) - '0';
            char tailChar = sb.charAt(sb.length() - 1);
            if (tailChar == '2') {
                if (sb.length() + x >= n) {
                    count += n - sb.length();
                } else {
                    count += x;
                }
                sb.append(x == 1 ? "1" : "11");
            } else {
                sb.append(x == 1 ? "2" : "22");
            }
            ix++;
        }
        return count;
    }
}
