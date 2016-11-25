package leetcode.L299_BullsAndCows;


/**
 * @author: deadend
 * @date: 4:14 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[][] map = new int[10][2];
        for (int i = 0; i < secret.length(); i++) {
            int ix = secret.charAt(i) - '0';
            int jx = guess.charAt(i) - '0';
            if (ix == jx) {
                bulls++;
            } else {
                map[ix][0]++;
                map[jx][1]++;
            }
        }

        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(map[i][0], map[i][1]);
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
    }
}
