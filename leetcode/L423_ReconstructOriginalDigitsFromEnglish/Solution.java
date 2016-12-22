package leetcode.L423_ReconstructOriginalDigitsFromEnglish;

/**
 * @author: deadend
 * @date: 1:28 PM 12/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private StringBuffer sb = new StringBuffer();

    private void append(int d, int count) {
        while (count-- > 0) {
            sb.append(d);
        }
    }

    public String originalDigits(String s) {
        final int SIZE = 26;
        int[] counter = new int[SIZE];

        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        append(0, counter['z' - 'a']);
        append(1, counter['o' - 'a'] - counter['z' - 'a'] - counter['w' - 'a'] - counter['u' - 'a']);
        append(2, counter['w' - 'a']);
        append(3, counter['t' - 'a'] - counter['w' - 'a'] - counter['g' - 'a']);
        append(4, counter['u' - 'a']);
        append(5, counter['f' - 'a'] - counter['u' - 'a']);
        append(6, counter['x' - 'a']);
        append(7, counter['s' - 'a'] - counter['x' - 'a']);
        append(8, counter['g' - 'a']);
        append(9, counter['i' - 'a'] - counter['x' - 'a'] - counter['g' - 'a'] - counter['f' - 'a'] + counter['u' - 'a']);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "owoztneoersssixixevennineeightnineseven";
        System.out.println(new Solution().originalDigits(s));
    }
}
