package leetcode.again.L306_AdditiveNumber;

/**
 * @author: deadend
 * @date: 8:04 PM 3/5/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean isAdditive(String num, long prev, long curr, int i) {
        while (i < num.length()) {
            long next = prev + curr;
            String snext = String.valueOf(next);
            if (!num.substring(i).startsWith(snext)) {
                return false;
            }
            prev = curr;
            curr = next;
            i += snext.length();
        }
        return true;
    }

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            String sprev = num.substring(0, i);
            for (int j = i + 1; j < num.length(); j++) {
                String scurr = num.substring(i, j);
                if (isAdditive(num, Long.valueOf(sprev), Long.valueOf(scurr), j)) {
                    return true;
                }
                if (num.charAt(i) == '0') {
                    break;
                }
            }
            if (num.charAt(0) == '0') {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "112";
        System.out.println(new Solution().isAdditiveNumber(s));
    }
}
